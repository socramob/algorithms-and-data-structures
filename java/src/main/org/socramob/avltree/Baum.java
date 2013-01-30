package org.socramob.avltree;


interface Baum<T> {
    T value();

    boolean empty();

    Integer height();

    Baum<T> insert(T element) throws DuplicateEntryException;

    void visit(BaumVisitor visitor);

    Baum<T> delete(T element) throws ElementNotFound;
}
