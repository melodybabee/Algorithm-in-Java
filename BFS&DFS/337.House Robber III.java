/*
DFS to find two situations:
root + non-root.left + non-root.right
root.left + root.right
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        // Corner cases
        if (root == null) {
            return 0;
        }
        int total = 0;
        if (root.left != null) {
            total += rob(root.left.left) + rob(root.left.right);
        }
        
        if (root.right != null) {
            total += rob(root.right.left) + rob(root.right.right);
        }
        
        return Math.max(total + root.val, rob(root.left) + rob(root.right));
    }
}