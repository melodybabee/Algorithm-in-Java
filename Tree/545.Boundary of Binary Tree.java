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
    private List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // Corner cases
        if (root == null) {
            return res;
        } else {
            res.add(root.val);
            if (isLeaf(root)) {
                return res;
            }
        }
        if(root.left != null) addLeftEdge(root.left);
        addLeaf(root);
        if(root.right != null) addRightEdge(root.right);
        return res;
    }
    
    // left edge, except the root itself and the left corner leaf
    private void addLeftEdge(TreeNode node) {
        if (node.left != null) {
            res.add(node.val);
            addLeftEdge(node.left);
        } else if (node.right != null) {
            res.add(node.val);
            addLeftEdge(node.right);
        }
    }
    
    // The last level of this tree
    private void addLeaf(TreeNode node) {
        if (isLeaf(node)) {
            res.add(node.val);
        }
        if (node.left != null) addLeaf(node.left);
        if (node.right != null) addLeaf(node.right);
    }
    
    // right edge, except the root itself and the right corner leaf, from the bottom to the top
    private void addRightEdge(TreeNode node) {
        if (node.right != null) {
            addRightEdge(node.right);
            res.add(node.val);
        } else if (node.left != null) {
            addRightEdge(node.left);
            res.add(node.val);
        }
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}