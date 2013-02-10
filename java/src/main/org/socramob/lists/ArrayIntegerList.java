package org.socramob.lists;

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
    public ArrayIntegerList firstHalf() {
        ArrayIntegerList firstHalf = new ArrayIntegerList();
        for (int i = 0; i < middleIndex(); i++) {
            firstHalf.append(this.get(i));
        }
        return firstHalf;
    }

    private int middleIndex() {
        return size() / 2;
    }

    @Override
    public ArrayIntegerList secondHalf() {
        ArrayIntegerList secondHalf = new ArrayIntegerList();
        for (int i = middleIndex(); i < size(); i++) {
            secondHalf.append(this.get(i));
        }
        return secondHalf;
    }

    @Override
    public boolean equals(Object thatObject) {
        if(thatObject == null) {
            return false;
        }
        if(!thatObject.getClass().isAssignableFrom(this.getClass())) {
            return false;
        }
        ArrayIntegerList that = (ArrayIntegerList) thatObject;
        Object[] theseValues = this.items;
        Object[] thoseValues = that.items;
        if(theseValues.length != thoseValues.length) {
            return false;
        }
        for (int i = 0; i < theseValues.length; i++) {
            if(!theseValues[i].equals(thoseValues[i])) {
               return false;
           }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "[";
        if (items.length > 0) {
            result += items[0].toString();
            for (int i = 1; i < items.length; i++) {
                result += ",";
                result += items[i].toString();
            }
        }
        result += "]";
        return result;
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

    @Override
    public Integer greatestAllowedIndex() {
        return size() - 1;
    }

    @Override
    public void swapItemsAt(Integer positionA, Integer positionB) {
        Integer parkingSpace = get(positionA);
        items[positionA] = get(positionB);
        items[positionB] = parkingSpace;
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

    public static class IndexOutOfBoundsException extends RuntimeException { }
}
