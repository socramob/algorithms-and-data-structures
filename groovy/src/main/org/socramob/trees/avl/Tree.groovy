package org.socramob.trees.avl

interface Tree {
    def value()

    boolean empty()

    Integer getHeight()

    Tree insert(element) throws DuplicateEntryException
    Tree delete(element) throws ElementNotFound

    void visit(TreeVisitor visitor)
}
