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

// Using prev pointer to record the prev position'
// The disadvantage is the global variable is not safety for multi threading
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
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }
}
// Improve
// Create a Integer[] to record the prev value;
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
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        Integer[] prev = new Integer[1];
        prev[0] = null;
        return isValid(root, prev);
        
    }
    
    private boolean isValid(TreeNode root, Integer[] prev) {
        if (root == null) {
            return true;
        }
        if (!isValid(root.left, prev)) {
            return false;
        }
        
        if (prev[0] != null && prev[0] >= root.val) {
            return false;
        }
        prev[0] = root.val;
        return isValid(root.right, prev);
    }
}