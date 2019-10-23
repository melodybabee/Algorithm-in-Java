class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    private class UnionFind{
        private int[] parent;
        private int[] size;
        private int NOI = 0;
        private UnionFind(int m, int n) {
            this.parent = new int[m*n];
            this.size = new int[m*n];
            for (int i = 0; i < m * n; ++i) {
                parent[i] = -1;
            }
        }
        
        private boolean find(int p, int q) {
            return root(p) == root(q);
        }
        private void union(int p, int q) {
            int rootP = root(p);
            int rootQ = root(q);
            if (size[rootP] < size[rootQ]) {
                union(q,p);
            } else {
                // connect to the root, and update the root size
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                this.NOI--;
            }
        }
        private int root(int val) {
            int cur = val;
            while(parent[cur] != cur) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[val] = cur;
            return cur;
        }
        // It is a new island or not 
        private void buildIsland(int val) {
            if (parent[val] == -1) {
                parent[val] = val;
                size[val] = 1;
                this.NOI++;
            }
        }
        private boolean isIsland(int val) {
            return parent[val] != -1;
        } 
        
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        // Corner case
        if (positions == null || positions.length == 0 ) {
            return res;
        }
        UnionFind uf = new UnionFind(m,n);
        int len = positions.length;
        for (int[] position: positions) {
            int p = position[0] * n + position[1];
            // Add a new node and count + 1
            uf.buildIsland(p);
            for (int[] dir : DIRECTIONS) {
                int ii = position[0] + dir[0];
                int jj = position[1] + dir[1];
                int q = ii *n + jj;
                // The neighbor one is island or not and whether they have connected
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && uf.isIsland(q) && !uf.find(p,q) ) {
                    // Connected
                    uf.union(q,p);
                }
            }
            res.add(uf.NOI);
        }
        return res;
    }
}