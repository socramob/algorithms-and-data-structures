package org.socramob.trees.avl

class ElementNotFound extends RuntimeException {
    Object element

    ElementNotFound(Object element) {
       this.element = element
    }
}
