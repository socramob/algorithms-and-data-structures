package org.socramob.algorithms.sorting.mergesort;

import org.junit.Test;
import org.socramob.abstractdatastructures.lists.ArrayIntegerList;
import org.socramob.abstractdatastructures.lists.IntegerList;

import static org.junit.Assert.assertEquals;

public class MergeTest {

    protected IntegerList emptyList() {
        return ArrayIntegerList.emptyList();
    }

    protected IntegerList listWithItems(Integer... items) {
        return ArrayIntegerList.withItems(items);
    }


    @Test
    public void given_two_empty_lists__returns_an_empty_list() throws Exception {
        IntegerList mergedList = MergeSort.merge(emptyList(), emptyList());

        assertEquals(emptyList(), mergedList);
    }

}
