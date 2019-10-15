/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: O(N), space, O(logN);
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        //Corner cases
        if (root == null) {
            return false;
        }
        // left side of BST
        Stack<TreeNode> leftS = new Stack<TreeNode>();
        addLeft(root, leftS);
        // right side of BST
        Stack<TreeNode> rightS = new Stack<TreeNode>();
        addRight(root, rightS);
        
        while (!leftS.isEmpty() && !rightS.isEmpty()) {
            // when the value of peek element is equals, that means find the mid postion
            if (leftS.peek() == rightS.peek()) {
                return false;
            }
            int leftVal= leftS.peek().val;
            int rightVal = rightS.peek().val;
            if (leftVal + rightVal == k) {
                return true;
            } else if (leftVal + rightVal < k) {
                TreeNode l = leftS.pop();
                addLeft(l.right, leftS);
            } else {
                TreeNode r = rightS.pop();
                addRight(r.left, rightS);
            }
        }
        return false;
    }
    // Always push left side into stack
    private void addLeft(TreeNode root, Stack<TreeNode> st) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    // Always push right side into stack
    private void addRight(TreeNode root, Stack<TreeNode> st) {
        while(root != null) {
            st.push(root);
            root = root.right;
        }
    }
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time O(N), space O(N)
// Use HashSet to find k - root.val
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        return find(root, k, set);
    }
    
    private boolean find(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
