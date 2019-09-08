// Find the shortest from every 1, do BFS for every 1 and calculate with the sum, get the MIN.
class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] grid) {
        // Corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] sumCost = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(i*col + j);
                    bfs(queue, grid, sumCost);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0 && sumCost[i][j] != 0) {
                    result = Math.min(result, sumCost[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    
    private void bfs(Queue<Integer> queue, int[][] grid, int[][] sumCost) {
        int row = grid.length;
        int col = grid[0].length;
        int minLen = 1;
        boolean[][] visited = new boolean[row][col];
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && jj >= 0 && ii < row && jj < col && !visited[ii][jj] && grid[ii][jj] == 0) {
                        sumCost[ii][jj] += minLen;
                        visited[ii][jj] = true;
                        queue.offer(ii*col + jj);
                    }
                }
            }
            ++minLen;
        }
        
        // There are some situations that 1 is stucked and cannot be reached.
        // So if there are any 0 that cannot reach 0, set it to 2. if there are all 2, then return -1.
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0 && visited[i][j] == false) {
                    grid[i][j] = 2;
                } 
            }
        }
        return;
    }
}