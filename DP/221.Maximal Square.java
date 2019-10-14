class Solution {
    public int maximalSquare(char[][] matrix) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                // Notice when do in-plave, the initial position may get the result, so should update the res as well
                if (i == 0 || j == 0) {
                    max = Math.max(max, matrix[i][j] - '0');
                } else if (matrix[i][j] == '1') {
                    char temp = (char)(Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) + 1);
                    matrix[i][j] = temp;
                    max = Math.max(max, temp - '0');
                } 
            }
        }
        return max * max;
    }
}