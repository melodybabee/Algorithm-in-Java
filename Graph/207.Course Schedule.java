class Solution {
    // using "," to split each element
    private enum Status {
        INITIAL,
        VISITING,
        VISITED;
    }
    private class V {
        private int val;
        private List<Integer> nexts;
        private Status status;
        private V (int val) {
            this.val = val;
            this.nexts = new ArrayList<Integer>();
            this.status = Status.INITIAL;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build Graph
        V[] graph = new V[numCourses];
        for (int i = 0 ; i < numCourses; ++i) {
            graph[i] = new V(i);
        }
        int len = prerequisites.length;
        for (int i = 0; i < len; ++i) {
            int cur = prerequisites[i][1];
            int prev = prerequisites[i][0];
            graph[cur].nexts.add(prev);
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (hasCycle(i, graph)) {
                return false;
            }
        }
        return true;
    }
    
    // Identify whether there is a cycle in the graph
    private boolean hasCycle(int i, V[] graph) {
        if (graph[i].status == Status.VISITING) {
            return true;
        }
        if (graph[i].status == Status.VISITED) {
            return false;
        }
        graph[i].status = Status.VISITING;
        for(int next : graph[i].nexts) {
            if (hasCycle(next, graph)) {
                return true;
            }
        }
        graph[i].status = Status.VISITED;
        return false;
    }
}