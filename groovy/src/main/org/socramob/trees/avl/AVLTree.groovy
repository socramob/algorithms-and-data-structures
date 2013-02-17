package org.socramob.trees.avl

class AVLTree {

    private Tree root = EmptyTree.emptyTree()


    AVLTree() { }

    boolean empty() {
        return root.empty()
    }

    boolean insert(element) {
        try {
            root = root.insert(element)
            return true
        } catch (DuplicateEntryException e) {
            return false
        }
    }

    boolean delete(element) {
        try {
            root = root.delete(element)
            return true
        } catch (ElementNotFound e) {
            return false
        }
    }

    Integer height() {
        return root.height
    }

    void visit(TreeVisitor treeVisitor) {
        root.visit(treeVisitor)
    }
}
