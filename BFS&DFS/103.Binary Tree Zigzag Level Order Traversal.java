// Solution 1: two stacks
// Because the order will be changed the order of input, using two stacks to change the order.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (root == null) return result;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        
        st1.push(root);
        int level = 0;
        while (!st1.isEmpty() || !st2.isEmpty()){
            if (level%2 == 0) {
                int size = st1.size();
                List<Integer> sol = new ArrayList<Integer>();
                for (int i = 0; i < size; ++i) {
                    TreeNode temp = st1.pop();
                    sol.add(temp.val);
                    if(temp.left != null) st2.push(temp.left);
                    if(temp.right != null) st2.push(temp.right);
                }
                result.add(sol);
            } else {
                int size = st2.size();
                List<Integer> sol = new ArrayList<Integer>();
                for (int i = 0; i < size; ++i) {
                    TreeNode temp = st2.pop();
                    sol.add(temp.val);
                    if(temp.right != null) st1.push(temp.right);
                    if(temp.left != null) st1.push(temp.left);
                }
                result.add(sol);
            }
            ++level;
            level %=2;
        }
        return result;
    }
}

// Solution 2: deque
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (root == null) return result;
        // Deque is also a interface that should be implemented by LinkedList
        Deque<TreeNode> deq = new LinkedList<>();
        
        deq.offerLast(root);
        int level = 0;
        while (!deq.isEmpty()){
            int size = deq.size();
            // Normal case
            if (level%2 == 0) {
                List<Integer> sol = new ArrayList<Integer>();
                for (int i = 0; i < size; ++i) {
                    TreeNode temp = deq.pollFirst();
                    sol.add(temp.val);
                    if(temp.left != null) deq.offerLast(temp.left);
                    if(temp.right != null) deq.offerLast(temp.right);
                }
                result.add(sol);
            } else {
                List<Integer> sol = new ArrayList<Integer>();
                for (int i = 0; i < size; ++i) {
                    TreeNode temp = deq.pollLast();
                    sol.add(temp.val);
                    if(temp.right != null) deq.offerFirst(temp.right);
                    if(temp.left != null) deq.offerFirst(temp.left);
                }
                result.add(sol);
            }
            ++level;
            level %=2;
        }
        return result;
    }
}