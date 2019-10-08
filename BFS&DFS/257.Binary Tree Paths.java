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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, root);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        // Root will always append to the StringBuilder
        sb.append(root.val + "->");
        // Set length
        int len = sb.length();
        dfs(res, sb, root.left);
        // Return to length
        sb.setLength(len);
        dfs(res, sb, root.right);
    }
}