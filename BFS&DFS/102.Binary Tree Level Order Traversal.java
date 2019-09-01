// List is an interface and cannot be instantiated. So it should be implements by ArrayList or LinkedList
// T(n) = O(n);
// BFS, preferred
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // this should come before corner case so that dealing with corner case
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sol = new ArrayList<Integer>();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = q.poll();
                sol.add(temp.val);
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
            result.add(sol);
        }
        return result;
    }
}

// Recursion
// The level is when the new level is over the size of result, then add a new null arraylist to the result
// Two for loop is left and right
// when add a new null arraylist, could add root.val to the result arraylist
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
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Corner cases
        if (root == null) {
            return result;
        }
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        // In arrayList should use get() to get sub arraylist and add value
        result.get(level).add(root.val);
        // must be root.left != null, root.left cannot be boolean
        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);
    }
}

