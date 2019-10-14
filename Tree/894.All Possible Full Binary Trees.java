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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        // Base cases
        if (N == 1) {
            TreeNode node = new TreeNode(0);
            res.add(node);
            return res;
        }
        // Start from 1
        for (int i = 1; i < N; ++ i) {
            List<TreeNode> left = allPossibleFBT(i);
            // Should always keep a value as the root
            List<TreeNode> right = allPossibleFBT(N-i-1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}