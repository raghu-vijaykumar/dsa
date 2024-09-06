package dsajava.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void testInsertAndContains() {
        BinarySearchTree bst = new BinarySearchTree();

        // Test inserting values
        assertTrue(bst.insert(10));
        assertTrue(bst.insert(5));
        assertTrue(bst.insert(15));
        assertTrue(bst.insert(2));
        assertTrue(bst.insert(7));
        assertFalse(bst.insert(10)); // Duplicate value

        // Test if values are in the tree
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
        assertTrue(bst.contains(2));
        assertTrue(bst.contains(7));
        assertFalse(bst.contains(8)); // Non-existing value
    }

    @Test
    public void testBFS() {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting values
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);

        // Expected BFS result: [10, 5, 15, 2, 7]
        ArrayList<Integer> bfsResult = bst.BFS();
        ArrayList<Integer> expectedBFS = new ArrayList<>();
        expectedBFS.add(10);
        expectedBFS.add(5);
        expectedBFS.add(15);
        expectedBFS.add(2);
        expectedBFS.add(7);

        assertEquals(expectedBFS, bfsResult);
    }

    @Test
    public void testPreOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting values
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);

        // Expected Pre-Order traversal result: [10, 5, 2, 7, 15]
        ArrayList<Integer> preOrderResult = bst.preOrder();
        ArrayList<Integer> expectedPreOrder = new ArrayList<>();
        expectedPreOrder.add(10);
        expectedPreOrder.add(5);
        expectedPreOrder.add(2);
        expectedPreOrder.add(7);
        expectedPreOrder.add(15);

        assertEquals(expectedPreOrder, preOrderResult);
    }

    @Test
    public void testInOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting values
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);

        // Expected In-Order traversal result: [2, 5, 7, 10, 15]
        ArrayList<Integer> inOrderResult = bst.inOrder();
        ArrayList<Integer> expectedInOrder = new ArrayList<>();
        expectedInOrder.add(2);
        expectedInOrder.add(5);
        expectedInOrder.add(7);
        expectedInOrder.add(10);
        expectedInOrder.add(15);

        assertEquals(expectedInOrder, inOrderResult);
    }

    @Test
    public void testPostOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting values
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);

        // Expected Post-Order traversal result: [2, 7, 5, 15, 10]
        ArrayList<Integer> postOrderResult = bst.postOrder();
        ArrayList<Integer> expectedPostOrder = new ArrayList<>();
        expectedPostOrder.add(2);
        expectedPostOrder.add(7);
        expectedPostOrder.add(5);
        expectedPostOrder.add(15);
        expectedPostOrder.add(10);

        assertEquals(expectedPostOrder, postOrderResult);
    }
}
