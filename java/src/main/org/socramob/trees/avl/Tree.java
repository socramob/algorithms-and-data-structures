package org.socramob.trees.avl;


interface Tree<T> {
    T value();

    boolean empty();

    Integer height();

    Tree<T> insert(T element) throws DuplicateEntryException;

    void visit(TreeVisitor visitor);

    Tree<T> delete(T element) throws ElementNotFound;
}
