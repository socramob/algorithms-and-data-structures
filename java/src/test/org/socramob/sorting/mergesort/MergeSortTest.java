package org.socramob.sorting.mergesort;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
    Integer[] sortedNumbers;

    @Test(expected = NullPointerException.class)
    public void when_given_null__it_throws_a_NullPoIntegererException() {
        sortedNumbers = MergeSort.sort(null);
    }

    @Test
    public void when_given_an_empty_array__it_returns_an_empty_array() {
        sortedNumbers = MergeSort.sort(emptyArray());

        assertArrayEquals(emptyArray(), sortedNumbers);
    }

    @Test
    public void when_given_a_one_element_array__it_returns_that_array() {
        sortedNumbers = MergeSort.sort(new Integer[]{17});

        assertArrayEquals(new Integer[]{17}, sortedNumbers);
    }

    @Test
    public void when_given_two_descending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = MergeSort.sort(new Integer[]{42, 17});

        assertArrayEquals(new Integer[]{17, 42}, sortedNumbers);
    }

    @Test
    public void when_given_two_ascending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = MergeSort.sort(new Integer[]{17, 42});

        assertArrayEquals(new Integer[]{17, 42}, sortedNumbers);
    }

    @Test
    public void when_given_an_arbitrary_list__it_returns_a_sorted_list_with_these_elements() {
        sortedNumbers = MergeSort.sort(new Integer[]{121, 42, 17});

        assertArrayEquals(new Integer[]{17, 42, 121}, sortedNumbers);
    }

    private Integer[] emptyArray() {
        return new Integer[0];
    }
}
