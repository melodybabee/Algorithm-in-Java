class Solution {
    public int numDistinctIslands(int[][] grid) {
        int count = 0;
        // Corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return count;
        }
        int row = grid.length;
        int col = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, 'c', path);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, char c, StringBuilder path) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        path.append(c);
        dfs(grid, i + 1, j, 'r', path);
        dfs(grid, i - 1, j, 'l', path);
        dfs(grid, i, j + 1, 'u', path);
        dfs(grid, i, j - 1, 'd', path);
        // when one dfs has finished, it should add 'b' that means it is ended.
        path.append('b');
    }
}