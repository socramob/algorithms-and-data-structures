package org.socramob.abstractdatastructures.trees.avl;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AVLTreeTest {

    private Integer anElement = 17;

    AVLTree<Integer> avlTree;

    @Test
    public void shouldBeEmpty() {
        avlTree = anEmptyTree();

        assertThat(avlTree.empty(), is(true));
    }


    @Test
    public void shouldNotBeEmpty_afterInsertingAnElement() {
        avlTree = anEmptyTree();

        avlTree.insert(anElement);

        assertThat(avlTree.empty(), is(false));
    }


    @Test
    public void should_increase_the_height() throws Exception {
        avlTree = anEmptyTree();

        avlTree.insert(anElement);

        assertThat(avlTree.height(), is(1));
    }

    @Test
    public void with_two_encreasing_elements__should_increase_the_height() throws Exception {
        avlTree = anEmptyTree();

        avlTree.insert(1);
        avlTree.insert(2);

        assertThat(avlTree.height(), is(2));
    }

    @Test
    public void with_two_decreasing_elements__should_increase_the_height() throws Exception {
        avlTree = anEmptyTree();

        avlTree.insert(2);
        avlTree.insert(1);

        assertThat(avlTree.height(), is(2));
    }

    @Test
    public void with_three_increasing_elements__should_increase_the_height() throws Exception {
        avlTree = anEmptyTree();

        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);

        assertThat(avlTree.height(), is(2));
    }

    @Test
    public void with_three_decreasing_elements__should_increase_the_height() throws Exception {
        avlTree = anEmptyTree();

        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);

        assertThat(avlTree.height(), is(2));
    }

    private static AVLTree<Integer> anEmptyTree() {
        return new AVLTree<Integer>();
    }

    @Test
    public void should_balance_a_sorted_list() {
        AVLTree<Integer> avlBaum = anEmptyTree();
        List<Integer> values = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        for(Integer value : values) {
            assertThat(avlBaum.insert(value), is(true));
        }

        assertThat(avlBaum.height(), is(4));
        assertTreeIsBalanced(avlBaum);
    }

    @Test
    public void should_balance_with_a_double_rotation() {
        AVLTree<Integer> avlBaum = anEmptyTree();
        List<Integer> values = asList(2, 1, 8, 9, 6, 5, 7);

        for(Integer value : values) {
            assertThat(avlBaum.insert(value), is(true));
        }

        assertTreeIsBalanced(avlBaum);
    }

    @Test
    public void should_delete_leaf() {
        avlTree = anEmptyTree();

        avlTree.insert(4);

        avlTree.delete(4);

        assertThat(avlTree.empty(), equalTo(true));
    }

    @Test
    public void should_replace_node_with_left_child() {
        avlTree = anEmptyTree();

        avlTree.insert(4);
        avlTree.insert(2);

        avlTree.delete(4);

        assertThat(avlTree.height(), equalTo(1));
    }

    @Test
    public void should_replace_node_with_right_child() {
        avlTree = anEmptyTree();

        avlTree.insert(4);
        avlTree.insert(6);

        avlTree.delete(4);

        assertThat(avlTree.height(), equalTo(1));
        assertThat(countNodesIn(avlTree), equalTo(1));
    }

    @Test
    public void should_replace_node_with_two_children() {
        avlTree = anEmptyTree();

        avlTree.insert(4);
        avlTree.insert(2);
        avlTree.insert(6);

        avlTree.delete(4);

        assertThat(countNodesIn(avlTree), equalTo(2));
    }

    @Test
    public void should_balance_after_deleting() {
        avlTree = anEmptyTree();

        avlTree.insert(4);
        avlTree.insert(2);
        avlTree.insert(6);
        avlTree.insert(1);
        avlTree.insert(3);

        avlTree.insert(5);
        avlTree.insert(7);

        assertThat(avlTree.height(), equalTo(3));
        assertTreeIsBalanced(avlTree);

        avlTree.delete(1);
        avlTree.delete(3);
        avlTree.delete(2);

        assertThat(avlTree.height(), equalTo(3));
        assertTreeIsBalanced(avlTree);
    }

    @Test
    public void random_test() {
        avlTree = anEmptyTree();

        Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            avlTree.insert(random.nextInt(1000));
            assertTreeIsBalanced(avlTree);
        }

        while(!avlTree.empty()) {
            avlTree.delete(random.nextInt(1000));
            assertTreeIsBalanced(avlTree);
        }

        assertThat(avlTree.empty(), equalTo(true));
    }

    @Test
    public void should_return_false_when_element_is_missing() {
        avlTree = anEmptyTree();

        avlTree.insert(4);
        avlTree.insert(2);
        avlTree.insert(6);
        avlTree.insert(1);
        avlTree.insert(3);

        avlTree.insert(5);
        avlTree.insert(7);

        assertThat(avlTree.delete(100), equalTo(false));
    }

    private void assertTreeIsBalanced(AVLTree<Integer> avlBaum) {
        avlBaum.visit(new DefaultTreeVisitor<Integer>() {
            @Override
            public void process(Branch<Integer> branch) {
                assertThat(branch.balance(), is(greaterThanOrEqualTo(-1)));
                assertThat(branch.balance(), is(lessThanOrEqualTo(1)));
                branch.leftSubtree().visit(this);
                branch.rightSubtree().visit(this);
            }
        });
    }

    private static int countNodesIn(AVLTree<Integer> avlBaum) {
        return new NodeCounter().countNodes(avlBaum);
    }

    private static class NodeCounter extends DefaultTreeVisitor<Integer> {
        private int actualN;

        @Override
        public void process(EmptyTree<Integer> emptyTree) { }

        @Override
        public void process(Branch<Integer> branch) {
            actualN++;
            branch.leftSubtree().visit(this);
            branch.rightSubtree().visit(this);
        }

        private int countNodes(AVLTree<Integer> avlBaum) {
            actualN = 0;
            avlBaum.visit(this);
            return actualN;
        }
    }
}
