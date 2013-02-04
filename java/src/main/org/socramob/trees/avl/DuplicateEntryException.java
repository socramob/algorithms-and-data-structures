package org.socramob.trees.avl;

class DuplicateEntryException extends RuntimeException {
    private final Object element;

    public DuplicateEntryException(Object element) {
        this.element = element;
    }
}
