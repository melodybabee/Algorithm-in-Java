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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        boolean flag = isSametree(s, t);
        // Start from every node of tree s and compare with itself, left subtree and right subtree
        return  flag || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }
}