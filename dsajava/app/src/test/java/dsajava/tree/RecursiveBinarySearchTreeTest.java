package dsajava.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RecursiveBinarySearchTreeTest {

    @Test
    public void testInsertAndContains() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        // Insert values
        bst.rInsert(10);
        bst.rInsert(5);
        bst.rInsert(15);
        bst.rInsert(2);
        bst.rInsert(7);
        bst.rInsert(12);
        bst.rInsert(20);

        // Test that the inserted values are correctly contained in the tree
        assertTrue(bst.rContains(10));
        assertTrue(bst.rContains(5));
        assertTrue(bst.rContains(15));
        assertTrue(bst.rContains(2));
        assertTrue(bst.rContains(7));
        assertTrue(bst.rContains(12));
        assertTrue(bst.rContains(20));

        // Test that values not inserted are not contained in the tree
        assertFalse(bst.rContains(9));
        assertFalse(bst.rContains(17));
        assertFalse(bst.rContains(100));
    }

    @Test
    public void testInsertDuplicates() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        // Insert duplicate values
        bst.rInsert(10);
        bst.rInsert(10); // Duplicate insert

        // Test that only one value exists in the tree
        assertTrue(bst.rContains(10));
    }

    @Test
    public void testEmptyTree() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        // Test contains on empty tree
        assertFalse(bst.rContains(10));
    }

    @Test
    public void testInsertSingleValue() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        // Insert a single value
        bst.rInsert(50);

        // Test that the value is correctly contained in the tree
        assertTrue(bst.rContains(50));
        assertFalse(bst.rContains(20));
    }
}
