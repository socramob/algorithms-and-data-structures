package org.socramob.avltree;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class AVLTreeTest {

    private Integer anElement = 17;

    AVLTree<Integer> avlBaum;

    @Test
    public void shouldBeEmpty() {
        avlBaum = anEmptyTree();

        assertThat(avlBaum.empty(), is(true));
    }


    @Test
    public void shouldNotBeEmpty_afterInsertingAnElement() {
        avlBaum = anEmptyTree();

        avlBaum.insert(anElement);

        assertThat(avlBaum.empty(), is(false));
    }


    @Test
    public void should_increase_the_height() throws Exception {
        avlBaum = anEmptyTree();

        avlBaum.insert(anElement);

        assertThat(avlBaum.height(), is(1));
    }

    @Test
    public void with_two_encreasing_elements__should_increase_the_height() throws Exception {
        avlBaum = anEmptyTree();

        avlBaum.insert(1);
        avlBaum.insert(2);

        assertThat(avlBaum.height(), is(2));
    }

    @Test
    public void with_two_decreasing_elements__should_increase_the_height() throws Exception {
        avlBaum = anEmptyTree();

        avlBaum.insert(2);
        avlBaum.insert(1);

        assertThat(avlBaum.height(), is(2));
    }

    @Test
    public void with_three_increasing_elements__should_increase_the_height() throws Exception {
        avlBaum = anEmptyTree();

        avlBaum.insert(1);
        avlBaum.insert(2);
        avlBaum.insert(3);

        assertThat(avlBaum.height(), is(2));
    }

    @Test
    public void with_three_decreasing_elements__should_increase_the_height() throws Exception {
        avlBaum = anEmptyTree();

        avlBaum.insert(3);
        avlBaum.insert(2);
        avlBaum.insert(1);

        assertThat(avlBaum.height(), is(2));
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
        avlBaum = anEmptyTree();

        avlBaum.insert(4);

        avlBaum.delete(4);

        assertThat(avlBaum.empty(), equalTo(true));
    }

    @Test
    public void should_replace_node_with_left_child() {
        avlBaum = anEmptyTree();

        avlBaum.insert(4);
        avlBaum.insert(2);

        avlBaum.delete(4);

        assertThat(avlBaum.height(), equalTo(1));
    }

    @Test
    public void should_replace_node_with_right_child() {
        avlBaum = anEmptyTree();

        avlBaum.insert(4);
        avlBaum.insert(6);

        avlBaum.delete(4);

        assertThat(avlBaum.height(), equalTo(1));
        assertThat(countNodesIn(avlBaum), equalTo(1));
    }

    @Test
    public void should_replace_node_with_two_children() {
        avlBaum = anEmptyTree();

        avlBaum.insert(4);
        avlBaum.insert(2);
        avlBaum.insert(6);

        avlBaum.delete(4);

        assertThat(countNodesIn(avlBaum), equalTo(2));
    }

    @Test
    public void should_balance_after_deleting() {
        avlBaum = anEmptyTree();

        avlBaum.insert(4);
        avlBaum.insert(2);
        avlBaum.insert(6);
        avlBaum.insert(1);
        avlBaum.insert(3);

        avlBaum.insert(5);
        avlBaum.insert(7);

        assertThat(avlBaum.height(), equalTo(3));
        assertTreeIsBalanced(avlBaum);

        avlBaum.delete(1);
        avlBaum.delete(3);
        avlBaum.delete(2);

        assertThat(avlBaum.height(), equalTo(3));
        assertTreeIsBalanced(avlBaum);
    }

    @Test
    public void random_test() {
        avlBaum = anEmptyTree();

        for(int i = 0; i < 1000; i++) {
            avlBaum.insert(new Random().nextInt(1000));
            assertTreeIsBalanced(avlBaum);
        }

        while(!avlBaum.empty()) {
            avlBaum.delete(new Random().nextInt(1000));
            assertTreeIsBalanced(avlBaum);
        }

        assertThat(avlBaum.empty(), equalTo(true));
    }

    @Test
    public void should_return_false_when_element_is_missing() {
        avlBaum = anEmptyTree();

        avlBaum.insert(4);
        avlBaum.insert(2);
        avlBaum.insert(6);
        avlBaum.insert(1);
        avlBaum.insert(3);

        avlBaum.insert(5);
        avlBaum.insert(7);

        assertThat(avlBaum.delete(100), equalTo(false));
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
