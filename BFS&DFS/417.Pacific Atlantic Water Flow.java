// BFS, start from top + left and bottom + right, find the overlap as the result
// T(n) = O(M+N) (find the edge point) + O(M*N)(BFS) +  O(M+N) (find the edge point) + O(M*N)(BFS) = O(M*N);
// S(n) = O(M*N);
// 换成int[][] 标记为不同数字不能减少空间复杂度，因为1 int = 4 bytes; 1 boolean = 1 bytes, and 2 boolean = 2 bytes;
// Object is always larger than primitive type. more than 10 bytes
class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        // Pacific
        //addPacificPoints(matrix, queue);// top left
        // the left-top point and bottom-right point cannot be calculated twice
        for (int i = 1; i < row; ++i) {
            queue.offer(i * col);
            // Make all notes into queue as true
            pacific[i][0] = true;
        }
        for (int j = 0; j < col; ++j) {
            queue.offer(j);
            pacific[0][j] = true;
        }
        bfs(queue, pacific, atlantic, res, matrix);
        //queue.clear(); It will return a null queue
        // Atlantic
        //addAtlanticPoints(matrix, queue);// bottom right
        for (int i = 0; i < row - 1; ++i) {
            queue.offer(i * col + col -1);
            atlantic[i][col-1] = true;
        }
        for (int j = 0; j < col; ++j) {
            queue.offer((row-1) * col + j);
            atlantic[row-1][j] = true;
        }
        bfs(queue, atlantic, pacific, res, matrix);
        return res;
    }
    
    private void bfs (Queue<Integer> queue, boolean[][] self, boolean[][] other, List<List<Integer>> res, int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur/col, j = cur%col;
            // other will always be empty when do BFS for the first time
            if (other[i][j] == true) {
                List<Integer> result = new ArrayList<>();
                result.add(i);
                result.add(j);
                res.add(result);
            } 
            for (int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && jj >= 0 && ii < row && jj < col && matrix[ii][jj] >= matrix[i][j] && self[ii][jj] == false) {
                    self[ii][jj] = true;
                    queue.offer(ii * col + jj);
                }
            }
        }
    }
}