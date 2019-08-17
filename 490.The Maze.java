注意：
        1.在JAVA中所有的变量都是对象，所以如果想返回一个int[]类型，那么就需要在返回的时候new一个new int[]{x,y}
        2.Boolean和boolean完全不同，所以如果写的格式不一样那么是两个不同干的东西
        3.判断两个数组是否相等要用Arrays.equals(start,destination)严格相等来判断
        4.如果声明为[][]格式的话那么一定要注意越界问题
        5.二维数组初始化int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};也要是二维的形式
        6.是length不是size()
        7.加入新的方法需要写public

        DFS:

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(start, destination, maze, visited);
    }

    public boolean dfs(int[] start, int[] destination, int[][] maze, boolean[][] visited) {
        if (Arrays.equals(start, destination)) return true;
        if (visited[start[0]][start[1]]) return false;
        visited[start[0]][start[1]] = true;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < dir.length; ++i) {
            int[] newstart = findend(start, maze, dir[i]);
            if (Arrays.equals(start, destination) || dfs(newstart, destination, maze, visited)) {
                return true;
            }
        }
        return false;
    }

    public int[] findend(int[] start, int[][] maze, int[] dir) {
        int x = start[0] + dir[0];
        int y = start[1] + dir[1];
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1) {
            return start;
        }
        int[] newstart = new int[]{x, y};
        return findend(newstart, maze, dir);
    }
}

BFS:
        注意：
        1.判断是否为空isEmpty()方法
        2.Queue<int[]>q=new LinkedList<>();是Collection中Queue接口与List、Set同一级别，都是继承了Collection接口
        LinkedList两个L大写
        包括q.offer()插入并返回true，如果队列已满，则返回false
        q.poll()移除并返问队列头部的元素，如果队列为空，则返回null
        q.peek()返回头部元素，如果队列为空，则返回null
        java抛出异常和返回阻塞时还有不同的操作【待学习】

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = false;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (Arrays.equals(cur, destination)) return true;
            for (int i = 0; i < dir.length; ++i) {
                int x = cur[0];
                int y = cur[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[i][0];
                    y += dir[i][1];
                }
                x -= dir[i][0];
                y -= dir[i][1];

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}