class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int path = dfs(matrix, i , j , Integer.MIN_VALUE, dp);
                res = Math.max(res, path);
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int i, int j, int prev, int[][] dp) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (i < 0 || i >= row || j < 0 || j >= col ||  prev >= matrix[i][j]) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int sol = 0;
        sol = Math.max(dfs(matrix, i + 1, j, matrix[i][j], dp), sol);
        sol = Math.max(dfs(matrix, i - 1, j, matrix[i][j], dp), sol);
        sol = Math.max(dfs(matrix, i, j + 1, matrix[i][j], dp), sol);
        sol = Math.max(dfs(matrix, i, j - 1, matrix[i][j], dp), sol);
        dp[i][j] =  sol + 1;
        return dp[i][j];
    }
}