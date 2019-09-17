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
    public int closestValue(TreeNode root, double target) {
        // Corner cases
        // If throw new NullPointerException(); should make a try...catch... block to deal with NullPointerException e. Exception is also a class 
        // Make a value to record cur value
        int result = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
            }
            if (root.val < target) {
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else {
                return root.val;
            }
        }
        return result;
    }
}