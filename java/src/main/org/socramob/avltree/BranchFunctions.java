package org.socramob.avltree;


import static org.socramob.avltree.Branch.createBranch;

class BranchFunctions {
    static <T extends Comparable<T>> Tree<T> balance(Branch<T> tree) {
        if (tree.hasLeftOverweight()) {
            return complexRotationToTheRight(tree);
        }
        if (tree.hasRightOverweight()) {
            return complexRotationToTheLeft(tree);
        }
        return tree;
    }

    static <T extends Comparable<T>> Tree<T> complexRotationToTheRight(Branch<T> tree) {
        Branch<T> leftBranch = tree.leftSubbranch();
        if (leftBranch.isLeaningToTheRight()) {
            return simpleRotationToTheRight(tree.withLeftSubtree(simpleRotationToTheLeft(leftBranch)));
        } else {
            return simpleRotationToTheRight(tree);
        }
    }

    static <T extends Comparable<T>> Tree<T> complexRotationToTheLeft(Branch<T> tree) {
        Branch<T> rightBranch = tree.rightSubbranch();
        if (rightBranch.isLeaningToTheLeft()) {
            return simpleRotationToTheLeft(tree.withRightSubtree(simpleRotationToTheRight(rightBranch)));
        } else {
            return simpleRotationToTheLeft(tree);
        }
    }

    static <T extends Comparable<T>> Tree<T> simpleRotationToTheRight(Branch<T> tree) {
        return createBranch(tree.leftSubbranch().value(),
                tree.leftSubbranch().leftSubtree(),
                createBranch(tree.value(),
                        tree.leftSubbranch().rightSubtree(),
                        tree.rightSubtree()));
    }

    static <T extends Comparable<T>> Tree<T> simpleRotationToTheLeft(Branch<T> tree) {
        return createBranch(tree.rightSubbranch().value(),
                createBranch(tree.value(),
                        tree.leftSubtree(),
                        tree.rightSubbranch().leftSubtree()),
                tree.rightSubbranch().rightSubtree());
    }

}
