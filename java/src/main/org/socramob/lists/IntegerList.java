package org.socramob.lists;

public class IntegerList {

    protected Integer[] items;

    private IntegerList(Integer... items) {
        this.items = items;
    }

    public static IntegerList emptyList() {
        return new IntegerList();
    }

    public static IntegerList withItems(Integer... items) {
        return new IntegerList(items);
    }

    public IntegerList firstHalf() {
        IntegerList firstHalf = new IntegerList();
        for (int i = 0; i < middleIndex(); i++) {
            firstHalf.append(this.get(i));
        }
        return firstHalf;
    }

    private int middleIndex() {
        return size() / 2;
    }

    public IntegerList secondHalf() {
        IntegerList secondHalf = new IntegerList();
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
        IntegerList that = (IntegerList) thatObject;
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

    public void append(Integer newItem) {
        Integer[] copiedItems = new Integer[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            copiedItems[i] = items[i];
        }

        items = copiedItems;
        items[items.length - 1] = newItem;
    }

    public Integer size() {
        return items.length;
    }

    public Integer get(Integer index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(index > greatestAllowedIndex()) {
            throw new IndexOutOfBoundsException();
        }

        return items[index];
    }

    public Boolean isEmpty() {
        return size() == 0;
    }

    public IntegerListIterator iterator() {
        return new IntegerListIterator();
    }

    public Integer greatestAllowedIndex() {
        return size() - 1;
    }

    public class IntegerListIterator {
        private Integer currentPosition;

        private IntegerListIterator() {
            currentPosition = 0;
        }

        public Integer getItem() {
            return get(currentPosition);
        }

        public void proceed() {
            currentPosition++;
        }

        public Boolean elementAvailable() {
            return currentPosition <= greatestAllowedIndex();
        }
    }

    public class IndexOutOfBoundsException extends RuntimeException { }
}
