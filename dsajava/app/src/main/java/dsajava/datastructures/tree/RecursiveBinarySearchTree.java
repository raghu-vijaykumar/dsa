package dsajava.datastructures.tree;

public class RecursiveBinarySearchTree {

    // Root node of the BST
    Node root;

    // Inner class to represent a node in the BST
    public class Node {
        int value;
        Node left;
        Node right;

        // Constructor for Node
        public Node(int value) {
            this.value = value;
        }
    }

    // Public method to check if a value exists in the BST
    public boolean rContains(int value) {
        return rContains(root, value);
    }

    // Recursive method to check if the value exists in the BST
    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) // Base case: Node is null, value not found
            return false;
        if (currentNode.value == value) // Base case: Value matches the node's value
            return true;
        if (value < currentNode.value) {
            // Recursive case: Check left subtree
            return rContains(currentNode.left, value);
        } else {
            // Recursive case: Check right subtree
            return rContains(currentNode.right, value);
        }
    }

    // Public method to insert a value in the BST
    public void rInsert(int value) {
        root = rInsert(root, value); // Update root, necessary for recursive insertion
    }

    // Recursive method to insert a value into the BST
    private Node rInsert(Node currNode, int value) {
        if (currNode == null) { // Base case: Found the insertion point
            return new Node(value);
        }
        if (value < currNode.value) {
            // Recursive case: Insert into left subtree
            currNode.left = rInsert(currNode.left, value);
        } else if (value > currNode.value) {
            // Recursive case: Insert into right subtree
            currNode.right = rInsert(currNode.right, value);
        }
        // Return the current node (updated subtree root)
        return currNode;
    }

    // Public method to delete a value from the BST
    public void rDelete(int value) {
        root = rDelete(root, value); // Update root after deletion
    }

    // Recursive method to delete a value from the BST
    private Node rDelete(Node currNode, int value) {
        if (currNode == null) // Base case: Node not found
            return null;

        if (value < currNode.value) {
            // Recursive case: Look in left subtree
            currNode.left = rDelete(currNode.left, value);
        } else if (value > currNode.value) {
            // Recursive case: Look in right subtree
            currNode.right = rDelete(currNode.right, value);
        } else {
            // Node to be deleted is found
            if (currNode.left == null && currNode.right == null) {
                // Case 1: Node is a leaf (no children)
                return null;
            } else if (currNode.left == null) {
                // Case 2: Node has only a right child
                currNode = currNode.right;
            } else if (currNode.right == null) {
                // Case 3: Node has only a left child
                currNode = currNode.left;
            } else {
                // Case 4: Node has two children
                // Find the minimum value in the right subtree
                int minValue = subTreeMin(currNode.right);
                // Replace the value of the node with the minimum value
                currNode.value = minValue;
                // Delete the duplicate node (min value node)
                currNode.right = rDelete(currNode.right, minValue);
            }
        }
        // Return the current node (updated subtree root)
        return currNode;
    }

    // Helper method to find the minimum value in a subtree
    private int subTreeMin(Node node) {
        // Keep going left to find the minimum value
        while (node.left != null) {
            node = node.left;
        }
        return node.value; // The leftmost node has the minimum value
    }
}
