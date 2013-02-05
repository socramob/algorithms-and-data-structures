package org.socramob.sorting.selectionsort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.model.MultipleFailureException.assertEmpty;

public class SelectionSortTest {
    int[] sortedNumbers;

    @Test(expected = NullPointerException.class)
    public void when_given_null__it__throws_a_NullPointerException() {
        sortedNumbers = SelectionSort.sort(null);
    }

    @Test
    public void when_given_an_empty_array__it_returns_an_empty_array() {
        sortedNumbers = SelectionSort.sort(emptyArray());

        assertArrayEquals(emptyArray(), sortedNumbers);
    }

    @Test
    public void when_given_a_one_element_array__it_returns_that_array() {
        sortedNumbers = SelectionSort.sort(new int[] {17});

        assertArrayEquals(new int[] {17}, sortedNumbers);
    }

    @Test
    public void when_given_two_descending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = SelectionSort.sort(new int[] {42, 17});

        assertArrayEquals(new int[] {17, 42}, sortedNumbers);
    }

    @Test
    public void when_given_two_ascending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = SelectionSort.sort(new int[] {17, 42});

        assertArrayEquals(new int[] {17, 42}, sortedNumbers);
    }

    @Test
    public void when_given_an_arbitrary_list__it_returns_a_sorted_list_with_these_elements() {
        sortedNumbers = SelectionSort.sort(new int[] {121, 17, 42});

        assertArrayEquals(new int[] {17, 42, 121}, sortedNumbers);
    }
    private int[] emptyArray() {
        return new int[0];
    }
}
