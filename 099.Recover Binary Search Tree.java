注意java没有swap函数，因此交换的时候需要设置中间变量

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        find(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {
                if (first == null) first = pre;
                second = root;
            }
            pre = root;
        }

        find(root.right);
    }
}


注意一定在判断存在不存在的时候要用null来判断，不能直接写

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode parent = null;
        TreeNode first = null;
        TreeNode second = null;
        while (cur != null) {
            if (cur.left == null) {
                if (parent != null && parent.val > cur.val) {
                    if (first == null) first = parent;
                    second = cur;
                }
                parent = cur;
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    if (parent != null && parent.val > cur.val) {
                        if (first == null) first = parent;
                        second = cur;
                    }
                    parent = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}