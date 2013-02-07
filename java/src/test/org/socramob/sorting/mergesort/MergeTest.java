package org.socramob.sorting.mergesort;

import org.junit.Test;
import org.socramob.lists.IntegerList;

import static org.junit.Assert.assertEquals;

public class MergeTest {
    @Test
    public void given_two_empty_lists__returns_an_empty_list() throws Exception {
        IntegerList mergedList = MergeSort.merge(IntegerList.emptyList(), IntegerList.emptyList());

        assertEquals(IntegerList.emptyList(), mergedList);
    }

}
