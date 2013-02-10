package org.socramob.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayIntegerListIteratorTest extends ListIteratorTestTemplate {

    @Override
    protected IntegerList emptyList() {
        return ArrayIntegerList.emptyList();
    }

    @Override
    protected IntegerList listWithItems(Integer... items) {
        return ArrayIntegerList.withItems(items);
    }

}
