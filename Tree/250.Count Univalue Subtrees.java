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
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // Use a variable to record the root value of this tree, the baseVal in the main function doesn't matter
        dfs(root, 0);
        return count;
    }
    
    private boolean dfs(TreeNode root, int baseVal) {
        if (root == null) {
            return true;
        }
        boolean l = dfs(root.left, root.val);
        boolean r = dfs(root.right, root.val);
        if (!l || !r) {
            return false;
        }
        ++count;
        return root.val == baseVal;
    }
}