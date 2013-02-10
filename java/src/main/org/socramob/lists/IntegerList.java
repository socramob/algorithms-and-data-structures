package org.socramob.lists;

public abstract class IntegerList {

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object thatObject);

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

    abstract Integer greatestAllowedIndex();

    public abstract void swapItemsAt(Integer positionA, Integer positionB);

    public abstract IntegerList firstHalf();

    public abstract IntegerList secondHalf();

    public abstract IntegerListIterator iterator();

}
