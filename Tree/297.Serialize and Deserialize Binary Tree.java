/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// preorder + null makes tree to string
// Add "," in order to make it easier to deserialize, to split all Strings using ","
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Corner case
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        String sol = sb.toString();
        // The first one is ","
        return sol.substring(1);
    }
    
    private void build(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(",null");
            return;
        }
        sb.append("," + root.val);
        build(root.left, sb);
        build(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //Corner cases
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] ss = data.split(",");
        // Use linkedlist because could remove the top one faster
        List<String> list = new LinkedList<>();
        for (String s : ss) {
            list.add(s);
        }
        TreeNode tree = build(list);
        return tree;
    }
    
    private TreeNode build(List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        // get root
        String val = list.get(0);
        // remove first then the other part will get the updated new list
        list.remove(0);
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = build(list);
        root.right = build(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));