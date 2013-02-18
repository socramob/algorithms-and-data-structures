package org.socramob.algorithms.sorting.bubblesort;

import org.junit.Test;
import org.socramob.abstractdatastructures.lists.ArrayIntegerList;
import org.socramob.abstractdatastructures.lists.IntegerList;

import static org.junit.Assert.assertEquals;

public class BubbleSortTest {
    IntegerList sortedNumbers;


    protected IntegerList emptyList() {
        return ArrayIntegerList.emptyList();
    }

    protected IntegerList listWithItems(Integer... items) {
        return ArrayIntegerList.withItems(items);
    }


    @Test(expected = NullPointerException.class)
    public void when_given_null__it_throws_a_NullPointerException() {
        sortedNumbers = BubbleSort.sort(null);
    }

    @Test
    public void when_given_an_empty_list__it_returns_an_empty_list() {
        sortedNumbers = BubbleSort.sort(emptyList());

        assertEquals(emptyList(), sortedNumbers);
    }

    @Test
    public void when_given_a_one_element_list__it_returns_that_list() {
        sortedNumbers = BubbleSort.sort(listWithItems(17));

        assertEquals(listWithItems(17), sortedNumbers);
    }

    @Test
    public void when_given_two_descending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = BubbleSort.sort(listWithItems(42, 17));

        assertEquals(listWithItems(17, 42), sortedNumbers);
    }

    @Test
    public void when_given_two_ascending_numbers__it_returns_two_ascending_numbers() {
        sortedNumbers = BubbleSort.sort(listWithItems(17, 42));

        assertEquals(listWithItems(17, 42), sortedNumbers);
    }

    @Test
    public void when_given_an_arbitrary_list__it_returns_a_sorted_list_with_these_elements() {
        sortedNumbers = BubbleSort.sort(listWithItems(121, 42, 17));

        assertEquals(listWithItems(17, 42, 121), sortedNumbers);
    }

}
