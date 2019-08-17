注意：
        1.默认的数据类型直接赋值，如果需要初始化需要遍历。INT_MAX对应了Integer.MAX_VALUE
        2.对象类型需要<>来表示类型，()用来声明新的堆空间

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dp = new int[maze.length][maze[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        dp[start[0]][start[1]] = 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dir.length; ++i) {
                int x = cur[0];
                int y = cur[1];
                int temp = dp[x][y];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[i][0];
                    y += dir[i][1];
                    ++temp;
                }
                x -= dir[i][0];
                y -= dir[i][1];
                --temp;
                if (temp < dp[x][y]) {
                    dp[x][y] = temp;
                    q.offer(new int[]{x, y});
                }
            }
        }
        int result = dp[destination[0]][destination[1]];
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}