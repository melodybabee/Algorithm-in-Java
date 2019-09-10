/*
The oder is from top to down, and from left to right. So it should be BFS. DFS cannot totally satisfy this situation.
Use col property to record the position
*/
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (root == null) return result;
        
        // To record the TreeNode, Queue interface is implemented by LinkedList
        Queue<TreeNode> qnode = new LinkedList<TreeNode>();
        // To record the col
        Queue<Integer> qcol = new LinkedList<Integer>();
        qnode.offer(root);
        qcol.offer(0);
        
        // Use map to match TreeNode and col, it is also good using HashMap, then should record the min and max
        TreeMap<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        
        while (!qnode.isEmpty()) {
            TreeNode node = qnode.poll();
            int col = qcol.poll();
            
            if (map.containsKey(col)) {
                map.get(col).add(node.val);
            } else{
                map.put(col, new ArrayList<Integer>());
                map.get(col).add(node.val);
            }
            
            if (node.left != null) {
                qnode.offer(node.left);
                qcol.offer(col-1);
            }
            
            if (node.right != null) {
                qnode.offer(node.right);
                qcol.offer(col + 1);
            }
        }
        
        for (int i : map.keySet()) {
            result.add(map.get(i));
        }
        
        return result;
    }
}
