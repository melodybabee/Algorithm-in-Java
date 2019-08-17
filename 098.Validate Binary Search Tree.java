注意：
        1.调用long形式的最大最小值就是Long.MIN_VALUE，Long.MAX_VALUE， int形式的就是Integer.MIN_VALUE
        2.调用结构体里面的东西要用.
        根结点为空表示为root==null
        3.创建一个新的结点直接TreeNode cur=root即可，不需要区分为指针类型

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
    public boolean isValidBST(TreeNode root) {
        return isvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isvalid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isvalid(root.left, min, root.val) && isvalid(root.right, root.val, max);
    }
}
遍历的方法需要注意：
        1.Stack是一个对象，需要用对对象的方法处理，首字母大写，判断为空要用isEmpty()
        出栈用Stack.pop();
        2.非对象判断空用!=null

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
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || cur != null) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            TreeNode temp = st.pop();
            if (pre != null && pre.val >= temp.val) {
                return false;
            }
            pre = temp;
            cur = temp.right;
        }
        return true;
    }
}