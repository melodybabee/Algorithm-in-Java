// If use the method like 317, will be time exceed if there are too many input.
// O(M*N) for finding all nodes * O(M*N) for BFS
class Solution {
    public int minTotalDistance(int[][] grid) {
        // Corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] sumPath = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(i*col + j);
                    bfs(queue, grid, sumPath);
                }
            }
        }
        
        int len = Integer.MAX_VALUE;
        for (int i= 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                len = Math.min(len, sumPath[i][j]);
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
    
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    
    private void bfs(Queue<Integer> queue, int[][] grid, int[][] sumPath) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                int i = cur/col;
                int j = cur%col;
                // [[1],[1]] will be reached to position 1. which is different form 317
                // So in order to avoid the same node to be calculated repeatly, the 1 node should be marked as visited
                visited[i][j] = true;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && jj >= 0 && ii < row && jj < col && !visited[ii][jj]) {
                        sumPath[ii][jj] += len;
                        visited[ii][jj] = true;
                        queue.offer(ii*col + jj);
                    }
                }
            }
            ++len;
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    grid[i][j] = 2;
                }
            }
        }
        return;
    }
}

// Solution 2 no walls, improve using math method
// The ideal distance is always in the middle of two points, so that the distance doesn't change.
class Solution {
    public int minTotalDistance(int[][] grid) {
        // Corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        
        for (int i = 0 ; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        return sum(row) + sum(col);
        
    }
    
    private int sum(List<Integer> list) {
        int result = 0;
        // list library is Collections.sort();
        Collections.sort(list);
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            result += (list.get(end)-list.get(start));
            ++start;
            --end;
        }
        return result;
    }
}