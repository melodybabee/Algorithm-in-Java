// find the nearest distance to 0
// set 0 as the door to find 1, the first time that meeting 1 is the nearest distance
class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row][col];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ;i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(i*col + j);
                }
            }
        }
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    // notice the edge cases
                    // should justify result[ii][jj] == 0 then doing the updated, if it is not 0 which means it has find the nearest distance.
                    if(ii >= 0 && jj >= 0 && ii < row && jj < col && result[ii][jj] == 0 && matrix[ii][jj] != 0) {
                        result[ii][jj] = minLen;
                        queue.offer(ii*col + jj);
                    }
                }
            }
            ++minLen;
        }
        return result;
    }
}

// If dont user extra space
class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ;i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(i*col + j);
                } else {
                    //first should make other value which is not equals to 0 to Integer.MAX_VALUE
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur/col;
            int j = cur%col;
            for (int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                // update the value, if it less than current value + 1, continue; else, always + 1;
                if(ii < 0 || jj < 0 || ii >= row || jj >= col || matrix[ii][jj] <= matrix[i][j] + 1) continue;
                matrix[ii][jj] = matrix[i][j] + 1;
                queue.offer(ii*col + jj);
            }
          
        }
        return matrix;
    }
}