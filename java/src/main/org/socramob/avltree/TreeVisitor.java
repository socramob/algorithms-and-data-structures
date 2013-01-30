package org.socramob.avltree;


public interface TreeVisitor<T extends Comparable<T>> {
    void process(EmptyTree<T> emptyTree);
    void process(Branch<T> branch);
}
