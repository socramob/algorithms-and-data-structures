package org.socramob.sorting.bubblesort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {
    int[] sortedNumbers;

    @Test(expected = NullPointerException.class)
    public void when_given_null__it_throws_a_NullPointerException() {
        sortedNumbers = BubbleSort.sort(null);
    }

    @Test
    public void when_given_an_empty_array__it_returns_an_empty_array() {
        sortedNumbers = BubbleSort.sort(emptyArray());

        assertArrayEquals(emptyArray(), sortedNumbers);
    }

    @Test
    public void when_given_a_one_element_array__it_returns_that_array() {
        sortedNumbers = BubbleSort.sort(new int[] {17});

        assertArrayEquals(new int[] {17}, sortedNumbers);
    }

    @Test
    public void when_given_two_descending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = BubbleSort.sort(new int[] {42, 17});

        assertArrayEquals(new int[] {17, 42}, sortedNumbers);
    }

    @Test
    public void when_given_two_ascending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = BubbleSort.sort(new int[] {17, 42});

        assertArrayEquals(new int[] {17, 42}, sortedNumbers);
    }

    @Test
    public void when_given_an_arbitrary_list__it_returns_a_sorted_list_with_these_elements() {
        sortedNumbers = BubbleSort.sort(new int[] {121, 42, 17});

        assertArrayEquals(new int[] {17, 42, 121}, sortedNumbers);
    }

    private int[] emptyArray() {
        return new int[0];
    }
}
