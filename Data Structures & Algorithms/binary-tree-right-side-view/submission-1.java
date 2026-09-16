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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int level = q.size();
            list.add(q.peek().val);
            for (int i = 0; i < level; i++) {
                TreeNode current = q.poll();
                if (current.right != null) {
                    q.add(current.right);
                }
                if (current.left != null) {
                    q.add(current.left);
                } 
            }
        }
        return list;
    }
}
