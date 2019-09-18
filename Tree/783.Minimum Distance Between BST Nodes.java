// no need to do the arraylist then find the target, use a pointer record the former one, do the minus to compare
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
    private int len = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        helper(root);
        return len;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null) {
            len = Math.min(len, root.val-prev.val);
        }
        prev = root;
        helper(root.right);
    }
}