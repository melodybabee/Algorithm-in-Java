// Solution 1: using queue
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node head = null;
            while (size -- > 0) {
                Node temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                if (head == null) {
                    head = temp;
                } else {
                    head.next = temp;
                    head = head.next;
                }
            }
        }
        return root;
    }
}

// S(O) = O(1);
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // head is for recording the start of a new level
        Node head = null;
        // cur is for making the connection
        Node cur = null;
        Node temp = root;
        while (temp != null) {
            // for a single level
            while (temp != null) {
                if (temp.left != null) {
                    if (cur == null) {
                        head = temp.left;
                    } else {
                        cur.next = temp.left;
                    }
                    cur = temp.left;
                }
                if (temp.right != null) {
                    if (cur == null) {
                        head = temp.right;
                    } else {
                        cur.next = temp.right;
                    }
                    cur = temp.right;
                }
                temp = temp.next;
            }
            temp = head;
            head = null;
            cur = null;
        }
        return root;
    }
}