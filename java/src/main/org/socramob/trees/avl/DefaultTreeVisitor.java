package org.socramob.trees.avl;

public class DefaultTreeVisitor<T extends Comparable<T>> implements TreeVisitor<T> {
    @Override
    public void process(EmptyTree<T> emptyTree) {
        // Does nothing
    }

    @Override
    public void process(Branch<T> branch) {
        // Does nothing
    }
}
