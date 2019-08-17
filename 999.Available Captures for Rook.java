注意：
        1.声明方向数组的时候直接赋值即可int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        2.思路上是先判断p，计数，在此基础之上如果不等于.都break,比较巧妙

class Solution {
    public int numRookCaptures(char[][] board) {
        int p = 0;
        int q = 0;
        int res = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    p = i;
                    q = j;
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; ++i) {
            for (int x = p + dir[i][0], y = q + dir[i][1]; x >= 0 && y >= 0 && x < 8 && y < 8; x += dir[i][0], y += dir[i][1]) {
                if (board[x][y] == 'p') ++res;
                if (board[x][y] != '.') break;
            }
        }
        return res;
    }
}