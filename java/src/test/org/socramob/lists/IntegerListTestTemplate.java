package org.socramob.lists;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public abstract class IntegerListTestTemplate {

    protected abstract IntegerList copyList(IntegerList prototype);

    protected abstract IntegerList emptyList();

    protected abstract IntegerList listWithItems(Integer... items);


    @Test
    public void two_empty_lists_are_equal() throws Exception {
        IntegerList listA = emptyList();
        IntegerList listB = emptyList();

        assertEquals(listA, listB);
    }

    @Test
    public void two_lists_with_differing_numbers_are_different() throws Exception {
        IntegerList listA = listWithItems(5);
        IntegerList listB = listWithItems(17);

        assertNotEquals(listA, listB);
    }

    @Test
    public void two_lists_with_different_lengths_are_different() throws Exception {
        Assert.assertNotEquals(listWithItems(5), listWithItems(5, 42));
        Assert.assertNotEquals(listWithItems(5, 42), listWithItems(5));
    }

    @Test
    public void is_different_from_null() throws Exception {
        Assert.assertNotEquals(listWithItems(5), null);
    }

    @Test
    public void toString_returns_comma_separated_list_within_two_braces() throws Exception {
        Assert.assertEquals("[]", emptyList().toString());
        Assert.assertEquals("[5]", listWithItems(5).toString());
        Assert.assertEquals("[5,17]", listWithItems(5, 17).toString());
    }

    @Test
    public void append_adds_a_new_item_at_the_end() throws Exception {
        IntegerList list = listWithItems(17);

        list.append(5);

        Assert.assertEquals(listWithItems(17, 5), list);
    }

    @Test(expected = ArrayIntegerList.IndexOutOfBoundsException.class)
    public void get__throws_an_IndexOutOfBoundsException_when_requested_index_is_negative() {
        IntegerList list = listWithItems(17, 42, 5);

        list.get(-1);
    }

    @Test
    public void get_returns_the_element_with_index() throws Exception {
        IntegerList list = listWithItems(17, 42, 5);

        assertEquals(Integer.valueOf(17), list.get(0));
        assertEquals(Integer.valueOf(42), list.get(1));
        assertEquals(Integer.valueOf(5),  list.get(2));
    }

    @Test
    public void size_relates_to_the_number_of_items() throws Exception {
        Assert.assertEquals(Integer.valueOf(0), emptyList().size());
        Assert.assertEquals(Integer.valueOf(1), listWithItems(5).size());
    }

    @Test(expected = ArrayIntegerList.IndexOutOfBoundsException.class)
    public void get__throws_an_IndexOutOfBoundsException_when_requested_index_is_greater_than_greatest_allowed_index() {
        IntegerList list = listWithItems(17, 42, 5);

        list.get(list.greatestAllowedIndex() + 1);
    }

    @Test
    public void isEmpty_is_only_true_for_list_without_items() throws Exception {
        assertTrue(emptyList().isEmpty());
        assertFalse(listWithItems(17).isEmpty());
    }

    @Test
    public void copyOf_returns_a_new_instance_with_the_same_items() throws Exception {
        IntegerList prototype = listWithItems(17, 42, 5);

        IntegerList copy = copyList(prototype);

        assertEquals(prototype, copy);
        assertNotSame(prototype, copy);
    }

    @Test
    public void swapItems_exchanges_the_items_at_the_given_positions() throws Exception {
        IntegerList list = listWithItems(17, 42, 5);

        list.swapItemsAt(0, 2);

        Assert.assertEquals(listWithItems(5, 42, 17), list);
    }
}
