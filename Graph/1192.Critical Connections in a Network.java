class Solution {
    private int num = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        // corner cases
        if (connections == null || connections.size() == 0) {
            return res;
        }
        int[] node = new int[n];
        List[] matrix = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<Integer>();
        }
        for (List<Integer> conn : connections) {
            matrix[conn.get(0)].add(conn.get(1));
            matrix[conn.get(1)].add(conn.get(0));
        }
        dfs(0, -1, matrix, node, res);
        return res;
    }
    
    private int dfs(int i, int parent, List[] matrix, int[] node, List<List<Integer>> res) {
        if (node[i] != 0) return node[i];
        node[i] = num++;
        
        int minVal = Integer.MAX_VALUE;
        for (int next : (List<Integer>) matrix[i]) {
            if (next != parent) {
                int val = dfs(next, i, matrix, node, res);
                minVal = Math.min(minVal,val);
            }
        }
        if (minVal >= node[i]) {
            if (parent >= 0) res.add(Arrays.asList(parent, i));
        }
        return Math.min(minVal,node[i]);
    }
}