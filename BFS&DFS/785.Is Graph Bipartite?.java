// Solution 1: BFS
/*
0 is not colored, 1 is red, -1 is green.
The node should be colored different colors with its neighbers.
do the for loop of every line, then BFS, put its neighbers into queue
*/
// no corner case, if as normal, will be [[],[1],[],[3],[]] is wrong.
class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        
        // Iteration the line
        for (int i = 0; i < length; ++i) {
            if (color[i] != 0) continue;
            Queue<Integer> q = new LinkedList<Integer>();
            q.offer(i);
            color[i] = 1;
            
            // BFS
            while(!q.isEmpty()) {
                int temp = q.poll();
                for (int j : graph[temp]) {
                    if (color[j] == 0) {
                        color[j] = -color[temp];
                        q.offer(j);
                    } else if (color[j] == color[temp]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

// DFS
/*
level: the length of graph
step: the col
when find the neighbor is the same as itself, the boolean status of next node will decide the node before it.
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        
        for(int i = 0 ; i < graph.length; ++i) {
            if(color[i] == 0 && !dfs(graph, color, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] color, int col, int index) {
        if(color[index] != 0) {
            return color[index] == col;
        }
        color[index] = col;
        for (int i : graph[index]) {
            if (!dfs(graph, color, -col, i)) {
               return false;
            }
        }
        
        return true;
    }
}