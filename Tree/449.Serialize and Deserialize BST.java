/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Because BST has inorder, so that we don't need to add null at the end;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Corner cases
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        buildTree(sb,root);
        String sol = sb.toString();
        return sol.substring(1);
    }

    private void buildTree(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append("," + root.val);
        buildTree(sb, root.left);
        buildTree(sb, root.right);
    }

    // Decodes your encoded data to tree.
    // Use a stack to keep the upper limit of the stack. If it is larger than the top one, that means should add to the right part, the stack keeps to add which node's right part.
    public TreeNode deserialize(String data) {
        // Corner cases
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] ss = data.split(",");
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(Integer.valueOf(ss[0]));
        st.push(root);
        
        for (int i = 1; i < ss.length; ++i) {
            TreeNode cur = st.peek();
            TreeNode next = new TreeNode(Integer.valueOf(ss[i]));
            if (cur.val > next.val) {
                cur.left = next;
            } else {
                cur = st.pop();
                while (!st.isEmpty() && st.peek().val < next.val) {
                    cur = st.pop();
                }
                cur.right = next;
            }
            st.push(next);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));