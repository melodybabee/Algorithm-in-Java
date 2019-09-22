// Use queue to remove the leaf nodes and do it again and again till find the root. The num of answer is 1 or 2.
class Solution {
    private class TreeNode{
        private int val;
        private HashSet<Integer> set;
        
        // Constructor
        public TreeNode(int val) {
            this.val = val;
            set = new HashSet<>();
        }
        
        // Build the graph
        public void add(int val) {
            set.add(val);
        }
        
        // Identify whether it is the leaf node
        public boolean isleave() {
            return set.size() == 1;
        }
        
        // Delete the leaf node
        public void remove(int val) {
            set.remove(val);
        }
        
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        int nodepool = n;
        TreeNode[] tree = new TreeNode[n];
        // Build the node
        for (int i = 0; i < n; ++i) {
            tree[i] = new TreeNode(i);
        }
        // Build the edges
        for (int i = 0; i < edges.length; ++i) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        
        // Add the nodes with only one connections to the queue and remove it
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (tree[i].isleave()) {
                queue.add(i);
                nodepool--;
            }
        }
        while(nodepool > 0) {
            int size = queue.size();
            while(size-- > 0) {
                int temp = queue.poll();
                // Remove the connection with the leaf, if it is leaf, then push to the queue
                for(int i : tree[temp].set) {
                    tree[i].remove(temp);
                    if (tree[i].isleave()) {
                        // The node in the queue will always be the leaf node
                        queue.add(i);
                        nodepool--;
                    }
                }
            }
        }
        // when nodepool == 0, means we have iterates all nodes in the tree, the nodes left in the queue will be the root
        for (int i : queue) {
            res.add(i);
        }
        
        return res;
    }
}