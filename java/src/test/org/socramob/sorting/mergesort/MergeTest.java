package org.socramob.sorting.mergesort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeTest {
    @Test
    public void given_two_empty_arrays__returns_an_empty_array() throws Exception {
        Integer[] mergedArray = MergeSort.merge(emptyArray(), emptyArray());

        assertArrayEquals(emptyArray(), mergedArray);
    }

    private Integer[] emptyArray() {
        return new Integer[0];
    }
}
