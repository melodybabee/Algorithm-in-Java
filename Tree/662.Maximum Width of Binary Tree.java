// Use vertical info using a queue to record
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> qtree = new LinkedList<>();
        Queue<Integer> qint = new LinkedList<>();
        qtree.offer(root);
        qint.offer(0);
        int res = Integer.MIN_VALUE;
        while(!qtree.isEmpty()) {
            int size = qtree.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode temp = qtree.poll();
                int tval = qint.poll();
                if (i == 0) {
                    left = tval;
                }
                
                if (i == size - 1) {
                    right = tval;
                }
                // always start from 0
                if (temp.left != null) {
                    qtree.offer(temp.left);
                    qint.offer(tval * 2);
                }
                
                if (temp.right != null) {
                    qtree.offer(temp.right);
                    qint.offer(tval*2 + 1);
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}