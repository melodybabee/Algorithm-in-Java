class Solution {
    public int minPathSum(int[][] grid) {
        // Corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                // update init
                if (i == 0 && j == 0) {
                    continue;
                 // update init
                } else if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                 // update init
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][col -1];
    }
}