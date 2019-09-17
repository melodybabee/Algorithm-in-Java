// cannot simply change from maxmun binary tree, L 104. This is a situaton from one side is null.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        //return (left == 0 || right == 0) ? Math.max(left,right) + 1 : Math.min(left,right) + 1;
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1;
    }
}