/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Almost totally the same as L653, use stack to solve the BST problem
// One node means its subtree of the whole tree
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // Corner cases
        if (root1 == null || root2 == null) {
            return false;
        }
        Stack<TreeNode> leftS = new Stack<>();
        Stack<TreeNode> rightS = new Stack<>();
        addLeft(root1, leftS);
        addRight(root2, rightS);
        
        while(!leftS.isEmpty() && !rightS.isEmpty()) {
            int leftVal = leftS.peek().val;
            int rightVal = rightS.peek().val;
            if (leftVal + rightVal == target) {
                return true;
            } else if (leftVal + rightVal < target) {
                TreeNode l = leftS.pop();
                addLeft(l.right, leftS);
            } else {
                TreeNode r = rightS.pop();
                addRight(r.left, rightS);
            }
        }
        return false;
    }
    
    private void addLeft(TreeNode root, Stack<TreeNode> st) {
        while (root != null) {
            st.add(root);
            root = root.left;
        }
    }
    
    private void addRight(TreeNode root, Stack<TreeNode> st) {
        while (root != null) {
            st.add(root);
            root = root.right;
        }
    }
}