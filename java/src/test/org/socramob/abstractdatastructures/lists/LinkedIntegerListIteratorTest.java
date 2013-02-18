package org.socramob.abstractdatastructures.lists;

public class LinkedIntegerListIteratorTest extends ListIteratorTestTemplate {

    @Override
    protected IntegerList emptyList() {
        return LinkedIntegerList.emptyList();
    }

    @Override
    protected IntegerList listWithItems(Integer... items) {
        return LinkedIntegerList.withItems(items);
    }

}
