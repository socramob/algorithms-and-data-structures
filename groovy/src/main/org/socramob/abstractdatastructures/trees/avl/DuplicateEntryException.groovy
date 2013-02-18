package org.socramob.abstractdatastructures.trees.avl

class DuplicateEntryException extends RuntimeException {
    private final Object element

    DuplicateEntryException(Object element) {
        this.element = element
    }
}
