package org.socramob.abstractdatastructures.lists;

public class ArrayIntegerList extends IntegerList {

    protected Integer[] items;


    private ArrayIntegerList(Integer... items) {
        this.items = items;
    }

    public static ArrayIntegerList emptyList() {
        return new ArrayIntegerList();
    }

    public static ArrayIntegerList withItems(Integer... items) {
        return new ArrayIntegerList(items);
    }

    public static ArrayIntegerList copyOf(IntegerList prototype) {
        ArrayIntegerList copy = new ArrayIntegerList();
        IntegerListIterator prototypeIterator = prototype.iterator();
        while (prototypeIterator.elementAvailable()) {
            copy.append(prototypeIterator.getItem());
            prototypeIterator.proceed();
        }
        return copy;
    }

    @Override
    protected IntegerList createEmptyInstance() {
        return ArrayIntegerList.emptyList();
    }

    @Override
    public void set(int index, int value) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size()) {
            items[index] = value; return;
        }
        if(index == size()) {
            append(value); return;
        }
        append(null);
        set(index, value);
    }

    @Override
    public void append(Integer newItem) {
        Integer[] copiedItems = new Integer[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            copiedItems[i] = items[i];
        }

        items = copiedItems;
        items[items.length - 1] = newItem;
    }

    @Override
    public Integer size() {
        return items.length;
    }

    @Override
    public Integer get(Integer index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(index > greatestAllowedIndex()) {
            throw new IndexOutOfBoundsException();
        }

        return items[index];
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public IntegerListIterator iterator() {
        return new Iterator();
    }

    public class Iterator implements IntegerListIterator {
        private Integer currentPosition;

        private Iterator() {
            currentPosition = 0;
        }

        @Override
        public Integer getItem() {
            return get(currentPosition);
        }

        @Override
        public void proceed() {
            currentPosition++;
        }

        @Override
        public Boolean elementAvailable() {
            return currentPosition <= greatestAllowedIndex();
        }
    }

}
