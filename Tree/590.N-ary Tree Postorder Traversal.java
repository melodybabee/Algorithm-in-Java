/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            root = st.pop();
            result.add(0, root.val);
            for(Node node: root.children) {
                st.push(node);
            }
        }
        return result;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(Node root, List<Integer> result ) {
        if (root == null) {
            return;
        }
        for(Node node: root.children) {
            helper(node, result);
        }
        result.add(root.val);
    }
}