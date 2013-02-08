package org.socramob.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListIteratorTest {

    IntegerList list;
    IntegerList.Iterator iterator;

    @Before
    public void setUp() {
        list = IntegerList.withItems(0, 1, 2, 3);
    }

    @Test
    public void begins_with_the_first_element() {
        iterator = list.iterator();

        assertEquals(list.get(0), iterator.getItem());
    }

    @Test
    public void proceed__should_go_to_the_next_item() {
        iterator = list.iterator();

        iterator.proceed();

        assertEquals(list.get(1), iterator.getItem());
    }

    @Test
    public void elementAvailable__should_return_true_when_current_position_is_within_the_bounds_of_the_list() {
        iterator = list.iterator();

        assertEquals(true, iterator.elementAvailable());
    }

    @Test
    public void elementAvailable__should_return_false_when_current_position_is_out_of_bounds_of_the_list() {
        iterator = list.iterator();

        for (int i = 0; i < list.size(); i++) {
            iterator.proceed();
        }

        assertEquals(false, iterator.elementAvailable());
    }

}
