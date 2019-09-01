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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (root == null) return result;
        
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
            result.add(0,sol);
        }
        // Collections.reverse(result); is ok, but it is a void method. from import java.util.Collections;
        return result;
    }
}

// recursion 1, simply reverse
// the result is set as global or in the property is both ok
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        dfs(root, result, 0);
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(TreeNode root,List<List<Integer>> result, int level){
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        if (root.left != null) dfs(root.left, result, level + 1);
        if (root.right != null) dfs(root.right, result, level + 1);
        
    }
}

// recursion 2: if add from the top, then should change the get() position, or the first index will always 0, the order is also reversed
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        dfs(root, result, 0);
        return result;
    }
    
    private void dfs(TreeNode root,List<List<Integer>> result, int level){
        if (result.size() == level) {
            result.add(0,new ArrayList<Integer>());
        }
        result.get(result.size()-level-1).add(root.val);
        if (root.left != null) dfs(root.left, result, level + 1);
        if (root.right != null) dfs(root.right, result, level + 1);
        
    }
}