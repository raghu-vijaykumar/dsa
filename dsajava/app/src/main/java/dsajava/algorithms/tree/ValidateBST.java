package dsajava.algorithms.tree;

public class ValidateBST {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        // Base Case
        if (node == null)
            return true;

        if (node.val >= max || node.val <= min) {
            return false;
        }

        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);

    }
}
