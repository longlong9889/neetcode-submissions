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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean leftTree = isSubtree(root.left, subRoot);
        boolean rightTree = isSubtree(root.right, subRoot);
        boolean compare = false;
        if (root.val == subRoot.val) {
            compare = isSameTree(root, subRoot);
        }
        return leftTree || rightTree || compare;
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null || p == null && q != null) {
            return false;
        }
        boolean leftSubTree = isSameTree(p.left, q.left);
        boolean rightSubTree = isSameTree(p.right, q.right);
        return leftSubTree && rightSubTree && p.val == q.val;
    }
}
