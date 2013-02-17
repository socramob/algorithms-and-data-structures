package org.socramob.trees.avl

import static Branch.createBranch

class BranchFunctions {
    static balance(Branch tree) {
        if (tree.hasLeftOverweight()) {
            return komplexeRechtsrotation(tree)
        }
        if (tree.hasRightOverweight()) {
            return komplexeLinksrotation(tree)
        }
        return tree
    }

    static komplexeRechtsrotation(Branch tree) {
        def linkerZweig = tree.leftSubtree
        if (linkerZweig.isLeaningToTheRight()) {
            return einfacheRechtsrotation(tree.withLeftSubtree(einfacheLinksrotation(linkerZweig)))
        } else {
            return einfacheRechtsrotation(tree)
        }
    }

    static komplexeLinksrotation(Branch tree) {
        def rechterZweig = tree.rightSubtree
        if (rechterZweig.isLeaningToTheLeft()) {
            return einfacheLinksrotation(tree.withRightSubtree(einfacheRechtsrotation(rechterZweig)))
        } else {
            return einfacheLinksrotation(tree)
        }
    }

    static Tree einfacheRechtsrotation(Branch tree) {
        return createBranch(tree.leftSubtree.value(),
                tree.leftSubtree.leftSubtree,
                createBranch(tree.value,
                        tree.leftSubtree.rightSubtree,
                        tree.rightSubtree))
    }

    static einfacheLinksrotation(Branch tree) {
        return createBranch(tree.rightSubtree.value(),
                createBranch(tree.value,
                        tree.leftSubtree,
                        tree.rightSubtree.leftSubtree),
                tree.rightSubtree.rightSubtree)
    }

}
