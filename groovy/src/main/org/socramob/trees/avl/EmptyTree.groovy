package org.socramob.trees.avl

class EmptyTree implements Tree {
    private static final EmptyTree INSTANCE = new EmptyTree()

    final Integer height = 0

    static EmptyTree emptyTree() {
        INSTANCE
    }

    @Override
    def value() {
        throw new IllegalAccessError("EmptyTree has no value!")
    }

    @Override
    boolean empty() {
        return true
    }

    @Override
    Tree insert(element) {
        return Branch.createLeaf(element)
    }

    @Override
    Tree delete(element) {
        throw new ElementNotFound(element)
    }

    @Override
    void visit(TreeVisitor visitor) {
        visitor.process(this)
    }
}
