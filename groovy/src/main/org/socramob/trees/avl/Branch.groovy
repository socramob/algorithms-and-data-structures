package org.socramob.trees.avl

import static EmptyTree.emptyTree

class Branch implements Tree {

    final value
    final Tree leftSubtree
    final Tree rightSubtree

    static Branch createBranch(value, Tree leftSubtree, Tree rightSubtree) {
        return new Branch(value, leftSubtree, rightSubtree)
    }

    private Branch(value, Tree leftSubtree, Tree rightSubtree) {
        this.value = value
        this.leftSubtree = leftSubtree
        this.rightSubtree = rightSubtree
    }


    static Branch createLeaf(value) {
        return new Branch(value)
    }

    private Branch(value) {
        this(value, emptyTree(), emptyTree())
    }


    boolean isLeaningToTheLeft() {
        balance < 0
    }

    boolean isLeaningToTheRight() {
        balance > 0
    }

    boolean hasLeftOverweight() {
        balance < -1
    }

    boolean hasRightOverweight() {
        balance > 1
    }

    @Override
    def value() {
        value
    }

    @Override
    boolean empty() {
        false
    }

    Integer getHeight() {
        max(leftSubtree.height, rightSubtree.height) + 1
    }


    @Override
    String toString() {
        "Branch[$value]:h=$height,delta_h=$balance"
    }

    int getBalance() {
        -leftSubtree.height + rightSubtree.height
    }


    private static Integer max(Integer x, Integer y) {
        return x > y ? x : y
    }

    @Override
    Tree insert(newElement) throws DuplicateEntryException {
        if (newElement == this.value) {
            throw new DuplicateEntryException(newElement)
        }
        if (newElement > this.value) {
            return BranchFunctions.balance(insertRight(newElement))
        } else {
            return BranchFunctions.balance(insertLeft(newElement))
        }
    }

    @Override
    Tree delete(element) {
        if(element < this.value) {
            return BranchFunctions.balance(createBranch(value, leftSubtree.delete(element), rightSubtree))
        } else if(element == this.value) {
            if(leftSubtree.empty() && rightSubtree.empty()) {
                return emptyTree()
            }
            if(rightSubtree.empty()) {
                return leftSubtree
            }
            if(leftSubtree.empty()) {
                return rightSubtree
            }
            def replacement = leftSubtree.greatestElement
            return BranchFunctions.balance(createBranch(replacement, leftSubtree.delete(replacement), rightSubtree))
        } else if(element > this.value) {
            return BranchFunctions.balance(createBranch(value, leftSubtree, rightSubtree.delete(element)))
        }
    }

    def getGreatestElement() {
        if(rightSubtree.empty()) {
            return value
        }
        return rightSubtree.greatestElement
    }

    private Branch insertRight(element) {
        withRightSubtree(rightSubtree.insert(element))
    }

    private Branch insertLeft(element) {
        withLeftSubtree(leftSubtree.insert(element))
    }

    @Override
    void visit(TreeVisitor visitor) {
        visitor.process(this)
    }

    Branch withRightSubtree(Tree newRightSubtree) {
        return createBranch(value, leftSubtree, newRightSubtree)
    }

    Branch withLeftSubtree(Tree newLeftSubtree) {
        return createBranch(value, newLeftSubtree, rightSubtree)
    }

}
