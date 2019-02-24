注意：
Java中不能仅用cur.right来表示存在，必须化为boolean形式的，cur.right != null
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode newnode = new TreeNode(val);
        TreeNode cur = root;
        if(root.val < val){
            newnode.left = root;
            return newnode;
        }
        
        while(cur.right != null && cur.right.val > val){
            cur = cur.right;
        }
        newnode.left = cur.right;
        cur.right = newnode;
        return root;
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
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root != null && root.val > val){
            root.right = insertIntoMaxTree(root.right,val);
            return root;
        }
        TreeNode newnode = new TreeNode(val);
        newnode.left = root;
        return newnode;
    }
}