package org.socramob.trees.avl;


class EmptyTree<T extends Comparable<T>> implements Tree<T> {
    // Singleton / Fly weight pattern
    private static final EmptyTree INSTANCE = new EmptyTree();

    private EmptyTree() { }

    public static EmptyTree emptyTree() {
        return INSTANCE;
    }

    @Override
    public T value() {
        throw new IllegalAccessError("EmptyTree has no value");
    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Integer height() {
        return 0;
    }

    @Override
    public Tree<T> insert(T element) {
        return Branch.createLeaf(element);
    }

    @Override
    public void visit(TreeVisitor visitor) {
        visitor.process(this);
    }

    @Override
    public Tree<T> delete(T element) throws ElementNotFound {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
