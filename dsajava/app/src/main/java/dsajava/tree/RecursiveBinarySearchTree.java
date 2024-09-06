package dsajava.tree;

public class RecursiveBinarySearchTree {

    Node root;

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null)
            return false;
        if (currentNode.value == value)
            return true;
        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public void rInsert(int value) {
        root = rInsert(root, value);

    }

    private Node rInsert(Node currNode, int value) {
        if (currNode == null) {
            return new Node(value);
        }
        if (value < currNode.value) {
            currNode.left = rInsert(currNode.left, value);
        } else if (value > currNode.value) {
            currNode.right = rInsert(currNode.right, value);
        }
        return currNode;
    }

}
