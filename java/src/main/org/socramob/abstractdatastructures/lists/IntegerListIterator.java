package org.socramob.abstractdatastructures.lists;

public interface IntegerListIterator {
    Integer getItem();

    void proceed();

    Boolean elementAvailable();
}
