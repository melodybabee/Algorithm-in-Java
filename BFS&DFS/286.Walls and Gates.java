// find the nearest gate, start from gate to the room
// O(n) = O(m*n);
class Solution {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        // Corner cases
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (rooms[i][j] == 0) {
                    // Integer should be i*col + j, must be col, row cannot be unique
                    /*
                    [(0,0),(0,1),(0,2)] -> [0,1,2]
                    */
                    queue.offer(i*col + j);
                }
            }
        }
        int minLen = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                for (int[] dirt : DIRECTIONS) {
                    int ii = i + dirt[0];
                    int jj = j + dirt[1];
                    // Integer.MAX_VALUE;
                    if (ii >= 0 && jj >= 0 && ii < row && jj < col && rooms[ii][jj] == Integer.MAX_VALUE) {
                        rooms[ii][jj] = minLen;
                        queue.offer(ii*col + jj);
                    }
                }
            }
            ++minLen;
        }
        return;
    }
}