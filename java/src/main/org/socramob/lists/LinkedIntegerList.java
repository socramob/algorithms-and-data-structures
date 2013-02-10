package org.socramob.lists;

public class LinkedIntegerList extends IntegerList {

    private ChainLink firstElement = new EmptyChainLink(0);

    @Override
    protected IntegerList createEmptyInstance() {
        return LinkedIntegerList.emptyList();
    }

    @Override
    public void set(int index, int value) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        firstElement = firstElement.set(index, value);
    }

    public static LinkedIntegerList emptyList() {
        return new LinkedIntegerList();
    }

    public static LinkedIntegerList withItems(Integer... items) {
        return new LinkedIntegerList(items);
    }

    public static LinkedIntegerList copyOf(IntegerList prototype) {
        LinkedIntegerList copy = new LinkedIntegerList();
        IntegerListIterator prototypeIterator = prototype.iterator();
        while (prototypeIterator.elementAvailable()) {
            copy.append(prototypeIterator.getItem());
            prototypeIterator.proceed();
        }
        return copy;
    }


    private LinkedIntegerList(Integer... items) {
        for (int i = 0; i < items.length; i++) {
            append(items[i]);
        }
    }


    @Override
    public void append(Integer newItem) {
        firstElement = firstElement.append(newItem);
    }

    @Override
    public Integer size() {
        return firstElement.size();
    }

    @Override
    public Integer get(Integer index) {
        return firstElement.get(index);
    }

    @Override
    Boolean isEmpty() {
        return firstElement.isEmpty();
    }

    @Override
    public IntegerList firstHalf() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IntegerList secondHalf() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IntegerListIterator iterator() {
        return new Iterator();
    }

    private abstract static class ChainLink {
        Integer listIndex;
        Integer itemValue;

        public ChainLink(Integer listIndex, Integer itemValue) {
            this.listIndex = listIndex;
            this.itemValue = itemValue;
        }

        public Integer value() {
            return itemValue;
        }

        public abstract ChainLink append(Integer newItem);

        public abstract Integer size();

        public abstract Integer get(Integer index);

        public abstract Boolean isEmpty();

        public abstract ChainLink successor();

        public abstract ChainLink set(int index, int value);

        protected boolean hasIndex(Integer index) {
            return this.listIndex == index;
        }
    }

    private static class RegularChainLink extends ChainLink {
        ChainLink successor;

        public RegularChainLink(Integer listIndex, Integer itemValue) {
            this(listIndex, itemValue, new EmptyChainLink(listIndex + 1));
        }

        public RegularChainLink(Integer listIndex, Integer itemValue, ChainLink successor) {
            super(listIndex, itemValue);
            this.successor = successor;
        }

        @Override
        public ChainLink append(Integer newItem) {
            return new RegularChainLink(listIndex, itemValue, successor.append(newItem));
        }

        public Integer size() {
            return 1 + successor.size();
        }

        @Override
        public Integer get(Integer index) {
            if (this.hasIndex(index)) {
                return this.value();
            }
            return successor.get(index);
        }

        @Override
        public Boolean isEmpty() {
            return false;
        }

        @Override
        public ChainLink successor() {
            return successor;
        }

        @Override
        public ChainLink set(int index, int value) {
            if (this.hasIndex(index)) {
                return new RegularChainLink(index, value, successor());
            }
            return new RegularChainLink(this.listIndex, this.itemValue, successor().set(index, value));
        }
    }

    private static class EmptyChainLink extends ChainLink {
        public EmptyChainLink(int listIndex) {
            super(listIndex, null);
        }

        @Override
        public ChainLink append(Integer newItem) {
            return new RegularChainLink(listIndex, newItem);
        }

        @Override
        public Integer size() {
            return 0;
        }

        @Override
        public Integer get(Integer index) {
            throw new IntegerList.IndexOutOfBoundsException();
        }

        @Override
        public Boolean isEmpty() {
            return true;
        }

        @Override
        public ChainLink successor() {
            return this;
        }

        @Override
        public ChainLink set(int index, int value) {
            if (this.hasIndex(index)) {
                return new RegularChainLink(index, value);
            }
            return new RegularChainLink(this.listIndex, null, new EmptyChainLink(this.listIndex + 1).set(index, value));
        }
    }

    private class Iterator implements IntegerListIterator {
        private ChainLink currentElement = firstElement;

        @Override
        public Integer getItem() {
            return currentElement.value();
        }

        @Override
        public void proceed() {
            currentElement = currentElement.successor();
        }

        @Override
        public Boolean elementAvailable() {
            return !currentElement.isEmpty();
        }
    }
}
