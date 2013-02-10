package org.socramob.lists;

public interface IntegerListIterator {
    Integer getItem();

    void proceed();

    Boolean elementAvailable();
}
