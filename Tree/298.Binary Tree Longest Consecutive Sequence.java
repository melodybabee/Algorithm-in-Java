/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Get consecutive sequence from the parent to the child
class Solution {
    private int path = 0;
    public int longestConsecutive(TreeNode root) {
        longest(root);
        return path;
    }
    // Create the new function because the return value and the final result are not the same one
    private int longest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longest(root.left);
        int right = longest(root.right);
        int ret = 1;
        // consecutive should satisfy root.val + 1 == root.left.val
        if (root.left != null && root.val + 1 == root.left.val) {
            ret = left + 1;
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            ret = Math.max(ret, right + 1);
        }
        path = Math.max(path, ret);
        return ret;
    }
}

// follow up, if could from any nodes to any nodes, then the comtine process is different, but the logic is the same.