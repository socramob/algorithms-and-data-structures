package org.socramob.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void two_empty_lists_are_equal() throws Exception {
        IntegerList listA = IntegerList.emptyList();
        IntegerList listB = IntegerList.emptyList();

        assertEquals(listA, listB);
    }

    @Test
    public void two_lists_with_differing_numbers_are_different() throws Exception {
        IntegerList listA = IntegerList.withItems(5);
        IntegerList listB = IntegerList.withItems(17);

        assertNotEquals(listA, listB);
    }

    @Test
    public void two_lists_with_different_lengths_are_different() throws Exception {
        assertNotEquals(IntegerList.withItems(5), IntegerList.withItems(5, 42));
        assertNotEquals(IntegerList.withItems(5, 42), IntegerList.withItems(5));
    }

    @Test
    public void is_different_from_null() throws Exception {
        assertNotEquals(IntegerList.withItems(5), null);
    }

    @Test
    public void toString_returns_comma_separated_list_within_two_braces() throws Exception {
        assertEquals("[]", IntegerList.emptyList().toString());
        assertEquals("[5]", IntegerList.withItems(5).toString());
        assertEquals("[5,17]", IntegerList.withItems(5, 17).toString());
    }

    @Test
    public void append_adds_a_new_item_at_the_end() throws Exception {
        IntegerList list = IntegerList.withItems(17);

        list.append(5);

        assertEquals(IntegerList.withItems(17, 5), list);
    }

    @Test
    public void get_returns_the_element_with_index() throws Exception {
        IntegerList list = IntegerList.withItems(17, 42, 5);

        assertEquals(Integer.valueOf(17), list.get(0));
        assertEquals(Integer.valueOf(42), list.get(1));
        assertEquals(Integer.valueOf(5),  list.get(2));
    }

    @Test
    public void size_relates_to_the_number_of_items() throws Exception {
        assertEquals(Integer.valueOf(0), IntegerList.emptyList().size());
        assertEquals(Integer.valueOf(1), IntegerList.withItems(5).size());
    }

    @Test
    public void isEmpty_is_only_true_for_list_without_items() throws Exception {
        assertTrue(IntegerList.emptyList().isEmpty());
        assertFalse(IntegerList.withItems(17).isEmpty());
    }
}
