package org.socramob.lists;

public abstract class IntegerList {

    @Override
    public String toString() {
        String result = "[";
        if (size() > 0) {
            result += get(0).toString();
            for (int i = 1; i < size(); i++) {
                result += ",";
                result += get(i).toString();
            }
        }
        result += "]";
        return result;
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
        if(this.size() != that.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if(!this.get(i).equals(that.get(i))) {
               return false;
           }
        }
        return true;
    }

    public abstract void append(Integer newItem);

    public abstract Integer size();

    public abstract Integer get(Integer index);

    abstract Boolean isEmpty();

    public static Integer firstPosition() {
        return 0;
    }

    public Integer secondToLastPosition() {
        return size() - 2;
    }

    public Integer greatestAllowedIndex() {
        return size() - 1;
    }

    public void swapItemsAt(Integer positionA, Integer positionB) {
        Integer parkingSpace = get(positionA);
        set(positionA, get(positionB));
        set(positionB, parkingSpace);
    }

    public IntegerList firstHalf() {
        return sublist(0, middleIndex() - 1);
    }

    public IntegerList secondHalf() {
        return sublist(middleIndex(), greatestAllowedIndex());
    }

    public abstract IntegerListIterator iterator();

    private int middleIndex() {
        return size() / 2;
    }

    public IntegerList sublist(Integer leftBoundary, Integer rightBoundary) {
        IntegerList sublist = createEmptyInstance();
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            sublist.append(this.get(i));
        }
        return sublist;
    }

    protected abstract IntegerList createEmptyInstance();

    public abstract void set(int index, int value);

    public static class IndexOutOfBoundsException extends RuntimeException { }
}
