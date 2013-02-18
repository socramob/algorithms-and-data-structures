package org.socramob.abstractdatastructures.trees.avl;


class Branch<T extends Comparable<T>> implements Tree<T> {

    private final T value;
    private final Tree<T> leftSubtree;
    private final Tree<T> rightSubtree;

    public static <T extends Comparable<T>> Branch<T> createBranch(T value, Tree<T> leftSubtree, Tree<T> rightSubtree) {
        return new Branch<T>(value, leftSubtree, rightSubtree);
    }

    private Branch(T value, Tree<T> leftSubtree, Tree<T> rightSubtree) {
        this.value = value;
        this.leftSubtree = leftSubtree;
        this.rightSubtree = rightSubtree;
    }


    public static <T extends Comparable<T>> Branch<T> createLeaf(T value) {
        return new Branch<T>(value);
    }

    private Branch(T value) {
        this(value, EmptyTree.emptyTree(), EmptyTree.emptyTree());
    }

    boolean isLeaningToTheLeft() {
        return balance() < 0;
    }

    boolean isLeaningToTheRight() {
        return balance() > 0;
    }

    boolean hasLeftOverweight() {
        return balance() < -1;
    }

    boolean hasRightOverweight() {
        return balance() > 1;
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public Integer height() {
        return max(leftSubtree().height(), rightSubtree().height()) + 1;
    }

    private static Integer max(Integer x, Integer y) {
        return x > y ? x : y;
    }

    @Override
    public String toString() {
        return String.format("Branch[%d]:height=%d,balance=%d", value, height(), balance());
    }

    public int balance() {
        return (-leftSubtree().height() + rightSubtree().height());
    }

    @Override
    public Tree<T> insert(T newElement) throws DuplicateEntryException {
        if (newElement.compareTo(this.value) == 0) {
            throw new DuplicateEntryException(newElement);
        }
        if (newElement.compareTo(this.value) > 0) {
            return BranchFunctions.balance(createBranch(value, leftSubtree(), rightSubtree().insert(newElement)));
        } else {
            return BranchFunctions.balance(createBranch(value, leftSubtree().insert(newElement), rightSubtree()));
        }
    }

    @Override
    public void visit(TreeVisitor visitor) {
        visitor.process(this);
    }

    @Override
    public Tree<T> delete(T element) throws ElementNotFound {
        if (rightSubtree().empty() && leftSubtree().empty()) {
            return EmptyTree.emptyTree();
        } else if (rightSubtree().empty()) {
            return leftSubtree();
        } else if(leftSubtree().empty()) {
            return rightSubtree();
        } else {
            T replacement = leftSubbranch().greatestEntry();
            return BranchFunctions.balance(createBranch(replacement, leftSubbranch().delete(replacement), rightSubtree()));
        }
    }

    private T greatestEntry() {
        if(rightSubtree().empty()) {
            return this.value();
        }
        return rightSubbranch().greatestEntry();
    }

    Branch<T> withRightSubtree(Tree<T> newRightSubtree) {
        return createBranch(this.value(), this.leftSubtree(), newRightSubtree);
    }

    Branch<T> withLeftSubtree(Tree<T> newLeftSubtree) {
        return createBranch(this.value(), newLeftSubtree, this.rightSubtree());
    }

    Branch<T> rightSubbranch() {
        return (Branch<T>) rightSubtree();
    }

    Branch<T> leftSubbranch() {
        return (Branch<T>) leftSubtree();
    }

    public Tree<T> leftSubtree() {
        return leftSubtree;
    }

    public Tree<T> rightSubtree() {
        return rightSubtree;
    }
}
