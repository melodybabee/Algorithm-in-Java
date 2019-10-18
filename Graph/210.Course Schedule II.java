class Solution {
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
    private int curLoc = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        V[] graph = new V[numCourses];
        for (int i = 0 ; i < numCourses; ++i) {
            graph[i] = new V(i);
        }
        int len = prerequisites.length;
        for (int i = 0 ; i < len; ++i) {
            int fol = prerequisites[i][0];
            int cur = prerequisites[i][1];
            graph[cur].nexts.add(fol);
        }
        
        int[] res = new int[numCourses];
        // Use a property to record the position of the array
        curLoc = numCourses - 1;
        for (int i = 0 ; i < numCourses; ++i) {
            if(hasCycle(i, graph, res)) {
                // []
                return new int[0];
            }
        }
        return res;
    }
    
    private boolean hasCycle(int i, V[] graph, int[] res) {
        if (graph[i].status == Status.VISITING) {
            return true;
        }
        if (graph[i].status == Status.VISITED) {
            return false;
        }
        graph[i].status = Status.VISITING;
        for (int next : graph[i].nexts) {
            if (hasCycle(next, graph, res)) {
                return true;
            }
        }
        graph[i].status = Status.VISITED;
        // Insert from the back to the top
        res[curLoc--] = graph[i].val;
        return false;
    }
}