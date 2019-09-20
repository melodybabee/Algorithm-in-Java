// BFS
class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int total = 0;
        // Corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return total;
        }
        Queue<Integer> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if(grid[i][j] == '1') {
                    ++total;
                    queue.offer(i * col + j);
                    // bfs
                    bfs(queue, grid);
                }
            }
        }
        return total;
    }
    
    private void bfs(Queue<Integer> queue, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            int i = temp/col;
            int j = temp%col;
            grid[i][j] = '0';
            for(int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && jj >= 0 && ii < row && jj < col && grid[ii][jj] == '1') {
                    queue.offer(ii * col + jj);
                    grid[ii][jj] = '0';
                }
            }
        }
    }
}