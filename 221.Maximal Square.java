注意：
        Java中也可以通过ASCII码进行转换，dp[i][j]=matrix[i][j]-'0';

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int ret = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret * ret;
    }
}
优化：
        对声明的dp数组进行大一位处理，这样四周都是0，从第一行第一列开始更新，但是遍历数组的时候需要分别减1

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int ret = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; ++i) {
            for (int j = 1; j <= matrix[0].length; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret * ret;
    }
}