/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNode = maxDepth(root.left);
        int rightNode = maxDepth(root.right);
        diameter = Math.max(diameter, leftNode + rightNode);
        return Math.max(leftNode, rightNode) + 1;
    }
}
