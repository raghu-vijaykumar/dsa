package dsajava.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RecursiveBinarySearchTreeTest {

    @Test
    void testInsertAndContains() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        // Test inserting values into the tree
        bst.rInsert(50);
        bst.rInsert(30);
        bst.rInsert(70);
        bst.rInsert(20);
        bst.rInsert(40);
        bst.rInsert(60);
        bst.rInsert(80);

        // Test contains method
        assertTrue(bst.rContains(50));
        assertTrue(bst.rContains(30));
        assertTrue(bst.rContains(70));
        assertTrue(bst.rContains(20));
        assertTrue(bst.rContains(40));
        assertTrue(bst.rContains(60));
        assertTrue(bst.rContains(80));

        // Test contains for non-existent values
        assertFalse(bst.rContains(100));
        assertFalse(bst.rContains(10));
    }

    @Test
    void testDeleteLeafNode() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        bst.rInsert(50);
        bst.rInsert(30);
        bst.rInsert(70);
        bst.rInsert(20);

        // Delete a leaf node (20)
        bst.rDelete(20);

        // Verify the node was deleted
        assertFalse(bst.rContains(20));

        // Verify other nodes still exist
        assertTrue(bst.rContains(50));
        assertTrue(bst.rContains(30));
        assertTrue(bst.rContains(70));
    }

    @Test
    void testDeleteNodeWithOneChild() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        bst.rInsert(50);
        bst.rInsert(30);
        bst.rInsert(70);
        bst.rInsert(20);
        bst.rInsert(40);

        // Delete node with one child (30)
        bst.rDelete(30);

        // Verify the node was deleted
        assertFalse(bst.rContains(30));

        // Verify other nodes still exist
        assertTrue(bst.rContains(50));
        assertTrue(bst.rContains(20));
        assertTrue(bst.rContains(40));
        assertTrue(bst.rContains(70));
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        bst.rInsert(50);
        bst.rInsert(30);
        bst.rInsert(70);
        bst.rInsert(20);
        bst.rInsert(40);
        bst.rInsert(60);
        bst.rInsert(80);

        // Delete node with two children (70)
        bst.rDelete(70);

        // Verify the node was deleted
        assertFalse(bst.rContains(70));

        // Verify the tree structure is maintained
        assertTrue(bst.rContains(50));
        assertTrue(bst.rContains(30));
        assertTrue(bst.rContains(20));
        assertTrue(bst.rContains(40));
        assertTrue(bst.rContains(60));
        assertTrue(bst.rContains(80));
    }

    @Test
    void testDeleteRootNode() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        bst.rInsert(50);
        bst.rInsert(30);
        bst.rInsert(70);
        bst.rInsert(20);
        bst.rInsert(40);
        bst.rInsert(60);
        bst.rInsert(80);

        // Delete root node (50)
        bst.rDelete(50);

        // Verify the root was deleted
        assertFalse(bst.rContains(50));

        // Verify other nodes still exist
        assertTrue(bst.rContains(30));
        assertTrue(bst.rContains(20));
        assertTrue(bst.rContains(40));
        assertTrue(bst.rContains(70));
        assertTrue(bst.rContains(60));
        assertTrue(bst.rContains(80));
    }

    @Test
    void testDeleteNonExistentValue() {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree();

        bst.rInsert(50);
        bst.rInsert(30);
        bst.rInsert(70);

        // Delete a non-existent value (100)
        bst.rDelete(100);

        // Verify the tree remains unchanged
        assertTrue(bst.rContains(50));
        assertTrue(bst.rContains(30));
        assertTrue(bst.rContains(70));
    }

}
