package org.socramob.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayIntegerListTest extends IntegerListTestTemplate {

    protected ArrayIntegerList emptyList() {
        return ArrayIntegerList.emptyList();
    }

    protected ArrayIntegerList listWithItems(Integer... items) {
        return ArrayIntegerList.withItems(items);
    }

    protected ArrayIntegerList copyList(IntegerList prototype) {
        return ArrayIntegerList.copyOf(prototype);
    }

}
