package org.socramob.avltree;


import static org.socramob.avltree.EmptyTree.emptyTree;

public class AVLTree<T extends Comparable<T>> {

    private static final boolean INSERTION_SUCCESSFUL = true;
    private static final boolean INSERTION_FAILED = false;

    private Tree<T> root = emptyTree();

    public AVLTree() { }

    public boolean empty() {
        return root.empty();
    }

    public boolean insert(T element) {
        try {
            root = root.insert(element);
            return INSERTION_SUCCESSFUL;
        } catch (DuplicateEntryException e) {
            return INSERTION_FAILED;
        }
    }

    public boolean delete(T element) {
        root = root.delete(element);
        return false;
    }

    public Integer height() {
        return root.height();
    }

    public void visit(TreeVisitor<T> treeVisitor) {
        root.visit(treeVisitor);
    }
}
