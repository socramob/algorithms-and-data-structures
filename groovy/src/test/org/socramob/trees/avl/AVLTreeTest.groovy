package org.socramob.trees.avl

import org.junit.Test

import static org.hamcrest.Matchers.*
import static org.junit.Assert.assertThat

class AVLTreeTest {

    Integer anElement = 17
    Random random = new Random()

    AVLTree avlTree

    @Test
    void shouldBeEmpty() {
        avlTree = anEmptyTree()

        assertThat avlTree.empty(), equalTo(true)
    }


    @Test
    void shouldNotBeEmpty_afterInsertingAnElement() {
        avlTree = anEmptyTree()

        avlTree.insert(anElement)

        assertThat avlTree.empty(), equalTo(false)
    }


    @Test
    void should_increase_the_height() {
        avlTree = anEmptyTree()

        avlTree.insert(anElement)

        assertThat(avlTree.height(), equalTo(1))
    }

    @Test
    void with_two_increasing_elements__should_increase_the_height() {
        avlTree = anEmptyTree()

        avlTree.insert(1)
        avlTree.insert(2)

        assertThat(avlTree.height(), equalTo(2))
    }

    @Test
    void with_two_decreasing_elements__should_increase_the_height() {
        avlTree = anEmptyTree()

        avlTree.insert(2)
        avlTree.insert(1)

        assertThat(avlTree.height(), equalTo(2))
    }

    @Test
    void with_three_increasing_elements__should_increase_the_height() {
        avlTree = anEmptyTree()

        avlTree.insert(1)
        avlTree.insert(2)
        avlTree.insert(3)

        assertThat(avlTree.height(), equalTo(2))
    }

    @Test
    void with_three_decreasing_elements__should_increase_the_height() {
        avlTree = anEmptyTree()

        avlTree.insert(3)
        avlTree.insert(2)
        avlTree.insert(1)

        assertThat(avlTree.height(), equalTo(2))
    }

    private AVLTree anEmptyTree() {
        return new AVLTree()
    }

    @Test
    void should_balance_a_sorted_list() {
        avlTree = anEmptyTree()

        (1..15).each { value ->
            assertThat(avlTree.insert(value), equalTo(true))
        }

        assertThat(avlTree.height(), equalTo(4))
        assertTreeIsBalanced(avlTree)
    }

    @Test
    void should_balance_with_a_double_rotation() {
        avlTree = anEmptyTree()

        [2, 1, 8, 9, 6, 5, 7].each { value ->
            assertThat(avlTree.insert(value), equalTo(true))
        }

        assertTreeIsBalanced(avlTree)
    }

    @Test
    void should_delete_leaf() {
        avlTree = anEmptyTree()

        avlTree.insert(4)

        avlTree.delete(4)

        assertThat avlTree.empty(), equalTo(true)
    }

    @Test
    void should_replace_node_with_left_child() {
        avlTree = anEmptyTree()

        avlTree.insert(4)
        avlTree.insert(2)

        avlTree.delete(4)

        assertThat avlTree.height(), equalTo(1)
    }

    @Test
    void should_replace_node_with_right_child() {
        avlTree = anEmptyTree()

        avlTree.insert(4)
        avlTree.insert(6)

        avlTree.delete(4)

        assertThat avlTree.height(), equalTo(1)
        assertTreeHas_N_Nodes(avlTree, 1)
    }

    @Test
    void should_replace_node_with_two_children() {
        avlTree = anEmptyTree()

        avlTree.insert(4)
        avlTree.insert(2)
        avlTree.insert(6)

        avlTree.delete(4)

        assertTreeHas_N_Nodes(avlTree, 2)
    }

    @Test
    void should_balance_after_deleting() {
        avlTree = anEmptyTree()

        avlTree.insert(4)
        avlTree.insert(2)
        avlTree.insert(6)
        avlTree.insert(1)
        avlTree.insert(3)

        avlTree.insert(5)
        avlTree.insert(7)

        assertThat(avlTree.height(), equalTo(3))
        assertTreeIsBalanced(avlTree)

        avlTree.delete(1)
        avlTree.delete(3)
        avlTree.delete(2)

        assertThat(avlTree.height(), equalTo(3))
        assertTreeIsBalanced(avlTree)
    }

    @Test
    void random_test() {
        avlTree = anEmptyTree()

        1000.times {
            avlTree.insert(random.nextInt(1000))
            assertTreeIsBalanced(avlTree)
        }

        while(!avlTree.empty()) {
            avlTree.delete(random.nextInt(1000))
            assertTreeIsBalanced(avlTree)
        }

        assertThat(avlTree.empty(), equalTo(true))
    }

    @Test
    void should_return_false_when_element_is_missing() {
        avlTree = anEmptyTree()

        avlTree.insert(4)
        avlTree.insert(2)
        avlTree.insert(6)
        avlTree.insert(1)
        avlTree.insert(3)

        avlTree.insert(5)
        avlTree.insert(7)

        assertThat(avlTree.delete(100), equalTo(false))
    }

    private assertTreeIsBalanced(AVLTree avlTree) {
        avlTree.visit(new DefaultTreeVisitor() {
            @Override
            void process(Branch branch) {
                assertThat(branch.balance, greaterThanOrEqualTo(-1))
                assertThat(branch.balance, lessThanOrEqualTo(1))
                branch.leftSubtree.visit(this)
                branch.rightSubtree.visit(this)
            }
        })
    }

    private assertTreeHas_N_Nodes(AVLTree avlTree, Integer expectedN) {
        Integer actualN = 0

        avlTree.visit(new DefaultTreeVisitor() {
            @Override
            void process(Branch branch) {
                actualN++
                branch.leftSubtree.visit(this)
                branch.rightSubtree.visit(this)
            }
        })

        assertThat actualN, equalTo(expectedN)
    }
}
