// Iteration
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
    public int maxDepth(Node root) {
        // Corner casers
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        int height = 0;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                root = q.poll();
                for (Node node: root.children) {
                    q.offer(node);
                }
            }
            ++height;
        }
        return height;
    }
}

// Recursion
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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        
        int value = 0;
        for(Node node : root.children) {
            int max = maxDepth(node);
            if (max > value) {
                value = max;
            }
        }
        return value + 1;
    }
}