// Iteration
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
    public int countNodes(TreeNode root) {
        int total = 0;
        if (root == null) return total;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            total += size;
            while (size-- > 0) {
                root = q.poll();
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
        }
        return total;
    }
}

// Recursion
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// Use the property of complete tree and perfect tree
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
    public int countNodes(TreeNode root) {
        // Corner cases
        if (root == null) {
            return 0;
        }
        int heightL = getHeight(root.left);
        int heightR = getHeight(root.right);
        
        if (heightL == heightR) {
            // Math.pow() will return a double result, convert it to the int type
            return (int)Math.pow(2, heightL) - 1 + countNodes(root.right) + 1;
        } else if (heightL > heightR) {
            return (int)Math.pow(2, heightR) - 1 + countNodes(root.left) + 1;
        }
        return -1;
    }
    
    // complete tree could use left side to calculate the height
    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            ++height;
            root = root.left;
        }
        return height;
    }
}