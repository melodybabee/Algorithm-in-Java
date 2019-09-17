// T(n) = O(n) (for one level) * logN (the num of level)= O(NlogN);
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
    public boolean isBalanced(TreeNode root) {
        // Corner cases
        if (root == null) {
            return true;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        // Could prunning if the the height between left and right is larger than 1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}