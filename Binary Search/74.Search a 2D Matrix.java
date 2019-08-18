// Twice binary search
// O(logN) + O(logM);
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int left = 0;
        int right = matrix.length -1;
        int mid = 0;
        int row = -1;
        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return false;
        } else {
            row = right;
        }
        
        
        left = 0;
        right = matrix[0].length-1;
        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

// change index
// Extract this 2D array to a flat one, row = mid/array[0].length, col = mid%array[0]
// O(n) = O(logm*n);
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int left = 0;
        int right = matrix.length * matrix[0].length -1;
        int mid = 0;
        
        while (left <= right) {
            mid = left + (right-left)/2;
            
            int row = mid/matrix[0].length;
            int col = mid%matrix[0].length;
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }
}