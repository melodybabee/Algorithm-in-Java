// The base one is the left corner one
// O(n) = O(m+n);
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length -1;
        int col = 0;
        while (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length) {
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                ++col;
            } else {
                --row;
            }
        }
        
        return false;
    }
}