// binary tree could use root != null ||!st.isEmpty(), N-ray cannot
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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            root = st.pop();
            result.add(root.val);
            // from right to left
            for(int i = root.children.size() - 1; i >= 0; --i) {
                st.push(root.children.get(i));
            }
        }
        return result;
    }
}