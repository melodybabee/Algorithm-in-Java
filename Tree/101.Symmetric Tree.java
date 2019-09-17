//T(n) = O(n);
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetricTwo(root.left, root.right);
    }
    
    private boolean isSymmetricTwo(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) return false;
        return isSymmetricTwo(root1.left, root2.right) && isSymmetricTwo(root1.right, root2.left);
    }
}