/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// DFS in tree
class Solution {
    private TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        // Find two wrong positions
        TreeNode[] mistakes = new TreeNode[2];
        recover(root, mistakes);
        int temp = mistakes[0].val;
        mistakes[0].val = mistakes[1].val;
        mistakes[1].val = temp;
        return;
    }
    
    private void recover(TreeNode root, TreeNode[] mistakes) {
        if (root == null) {
            return;
        }
        recover(root.left, mistakes);
        if (prev != null && prev.val >= root.val) {
            // The mistakes[0] is the first wrong position, and the mistakes[1] is the second wrong position
            // always update the mistakes[1] to the root.val
            if (mistakes[0] == null) {
                 mistakes[0] = prev;
            }
            mistakes[1] = root;
        }
        prev = root;
        recover(root.right, mistakes);
    }
}