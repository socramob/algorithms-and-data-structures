package org.socramob.trees.avl

interface TreeVisitor {
    void process(EmptyTree emptyTree)
    void process(Branch branch)
}
