package org.socramob.lists;

public class LinkedIntegerListTest extends IntegerListTestTemplate {

    @Override
    protected LinkedIntegerList emptyList() {
        return LinkedIntegerList.emptyList();
    }

    @Override
    protected LinkedIntegerList listWithItems(Integer... items) {
        return LinkedIntegerList.withItems(items);
    }

    @Override
    protected LinkedIntegerList copyList(IntegerList prototype) {
        return LinkedIntegerList.copyOf(prototype);
    }

}
