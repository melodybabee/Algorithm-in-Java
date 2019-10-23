class Solution {
    class UnionFind {
        private int size;
        private int[] sz;
        private int[] ids;

        private UnionFind(int n) {
            this.size = n;
            this.sz = new int[n];
            this.ids = new int[n];
            for (int i = 0; i < n; ++i) {
                // Init the root points to itself
                ids[i] = i;
                // Init size is 1
                sz[i] = 1;
            }
        }
        
        private boolean find(int p, int q) {
            return root(p) == root(q);
        }
        
        private void union(int p, int q) {
            int rootP = root(p);
            int rootQ = root(q);
            if (sz[rootP] < sz[rootQ]) {
                int temp = rootP;
                rootP = rootQ;
                rootQ = temp;
            }
            // Always make rootP is root 
            ids[rootQ] = rootP;
            // the size of rootP is rootP + rootQ
            sz[rootP] += sz[rootQ];
            this.size--;
        }
        
        private int root(int val) {
            int temp = val;
            while(val != ids[val]) {
                ids[val] = ids[ids[val]];
                val = ids[val];
            }
            ids[temp] = val;
            return val;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // Corner cases
        if (edges == null) return false;
        int size = edges.length;
        if (size != n -1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            int p = e[0];
            int q = e[1];
            if (uf.find(p,q)) {
                return false;
            } else {
                uf.union(p,q);
            }
        }
        // Only one connected conponent
        return uf.size == 1;
    }
}