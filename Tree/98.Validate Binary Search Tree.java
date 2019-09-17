// inorder traveral: iterate or recursion, O(n)
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // keep long
        long cur = Long.MIN_VALUE;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                if (root.val <= cur) {
                    return false;
                }
                cur = root.val;
                root = root.right;
            }
        }
        return true;
    }
}

// Space: O(n) = 1, T(n) = O(NlogN), worst O(N^2)
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private boolean isValid (TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}