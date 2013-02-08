package org.socramob.sorting.selectionsort;

import org.junit.Assert;
import org.junit.Test;
import org.socramob.lists.IntegerList;

import static org.junit.Assert.assertEquals;

public class SelectionSortTest {
    IntegerList sortedNumbers;

    @Test(expected = NullPointerException.class)
    public void when_given_null__it__throws_a_NullPointerException() {
        sortedNumbers = SelectionSort.sort(null);
    }

    @Test
    public void when_given_an_empty_list__it_returns_an_empty_list() {
        sortedNumbers = SelectionSort.sort(emptyList());

        assertEquals(emptyList(), sortedNumbers);
    }

    @Test
    public void when_given_a_one_element_list__it_returns_that_list() {
        sortedNumbers = SelectionSort.sort(IntegerList.withItems(17));

        assertEquals(IntegerList.withItems(17), sortedNumbers);
    }

    @Test
    public void when_given_two_descending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = SelectionSort.sort(IntegerList.withItems(42, 17));

        assertEquals(IntegerList.withItems(17, 42), sortedNumbers);
    }

    @Test
    public void when_given_two_ascending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = SelectionSort.sort(IntegerList.withItems(17, 42));

        assertEquals(IntegerList.withItems(17, 42), sortedNumbers);
    }

    @Test
    public void when_given_an_arbitrary_list__it_returns_a_sorted_list_with_these_elements() {
        sortedNumbers = SelectionSort.sort(IntegerList.withItems(121, 17, 42));

        assertEquals(IntegerList.withItems(17, 42, 121), sortedNumbers);
    }
    private IntegerList emptyList() {
        return IntegerList.emptyList();
    }
}
