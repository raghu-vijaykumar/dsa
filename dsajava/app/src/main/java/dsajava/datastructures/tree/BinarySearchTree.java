package dsajava.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree {

    // Root node of the binary search tree
    Node root;

    // Class representing a node in the binary search tree
    public class Node {
        int value; // Value of the node
        Node left; // Left child of the node
        Node right; // Right child of the node

        // Constructor to initialize a node with a value
        public Node(int value) {
            this.value = value;
        }
    }

    // Insert a value into the binary search tree
    public boolean insert(int value) {
        // Create a new node with the provided value
        Node node = new Node(value);

        // If the tree is empty, set the new node as the root
        if (root == null) {
            root = node;
            return true;
        }

        // Start traversing the tree from the root
        Node temp = root;

        // Traverse the tree until the correct position is found
        while (true) {
            // If the value already exists in the tree, return false
            if (temp.value == value) {
                return false;
            }

            // If the value is smaller, go to the left subtree
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = node; // Insert as left child
                    return true;
                } else {
                    temp = temp.left; // Keep traversing the left subtree
                }
            }
            // If the value is larger, go to the right subtree
            else {
                if (temp.right == null) {
                    temp.right = node; // Insert as right child
                    return true;
                } else {
                    temp = temp.right; // Keep traversing the right subtree
                }
            }
        }
    }

    // Check if a value is present in the tree
    public boolean contains(int value) {
        // Start traversing from the root
        Node temp = root;

        // Traverse the tree until we either find the value or reach a leaf
        while (temp != null) {
            if (temp.value == value)
                return true; // Value found
            if (value < temp.value)
                temp = temp.left; // Move to the left subtree
            else
                temp = temp.right; // Move to the right subtree
        }

        // Return false if value not found
        return false;
    }

    // Perform a Breadth-First Search (BFS) traversal of the tree
    public ArrayList<Integer> BFS() {
        // List to store the BFS traversal result
        ArrayList<Integer> results = new ArrayList<>();

        // Queue to assist with level-order traversal
        LinkedList<Node> queue = new LinkedList<>();

        // Start BFS if the tree is not empty
        if (root != null) {
            // Add the root node to the queue
            queue.add(root);

            // Traverse the tree level by level
            while (!queue.isEmpty()) {
                // Remove the front node from the queue
                Node node = queue.remove();

                // Add the node's value to the result list
                results.add(node.value);

                // Add left child to the queue if it exists
                if (node.left != null) {
                    queue.add(node.left);
                }

                // Add right child to the queue if it exists
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // Return the result of BFS traversal
        return results;
    }

    // Perform a pre-order traversal (root -> left -> right)
    public ArrayList<Integer> preOrder() {
        // List to store the traversal result
        ArrayList<Integer> results = new ArrayList<>();

        // Nested class to handle the recursive traversal
        class Traverse {
            public Traverse(Node node) {
                if (node != null) {
                    results.add(node.value); // Visit the root node
                    new Traverse(node.left); // Traverse the left subtree
                    new Traverse(node.right); // Traverse the right subtree
                }
            }
        }

        // Start the traversal from the root
        new Traverse(root);
        return results;
    }

    // Perform an in-order traversal (left -> root -> right)
    public ArrayList<Integer> inOrder() {
        // List to store the traversal result
        ArrayList<Integer> results = new ArrayList<>();

        // Helper method to perform in-order traversal
        inOrderTraversal(root, results);

        // Return the result of in-order traversal
        return results;
    }

    // Helper method for in-order traversal
    private void inOrderTraversal(Node node, ArrayList<Integer> results) {
        if (node == null)
            return; // Base case: if node is null, return

        // Traverse the left subtree
        inOrderTraversal(node.left, results);

        // Visit the root node
        results.add(node.value);

        // Traverse the right subtree
        inOrderTraversal(node.right, results);
    }

    // Perform a post-order traversal (left -> right -> root)
    public ArrayList<Integer> postOrder() {
        // List to store the traversal result
        ArrayList<Integer> results = new ArrayList<>();

        // Helper method to perform post-order traversal
        postOrderTraversal(root, results);

        // Return the result of post-order traversal
        return results;
    }

    // Helper method for post-order traversal
    private void postOrderTraversal(Node node, ArrayList<Integer> results) {
        if (node == null)
            return; // Base case: if node is null, return

        // Traverse the left subtree
        postOrderTraversal(node.left, results);

        // Traverse the right subtree
        postOrderTraversal(node.right, results);

        // Visit the root node
        results.add(node.value);
    }
}
