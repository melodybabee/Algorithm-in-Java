// Recursion
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }
}