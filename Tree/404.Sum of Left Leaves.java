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
    public int sumOfLeftLeaves(TreeNode root) {
        // To record this branch is left or right
        return findSum(root, false);
    }
    
    private int findSum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        // To right that can be changed when it turn to left
        return findSum(root.left, true) + findSum(root.right, false);
    }
}