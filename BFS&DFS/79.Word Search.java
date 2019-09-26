// T(n) = O(M*N) + O(4^k); it is a tree with four branches, level 1: 4, level 2: 4*4; level 3: 4*4*4;
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        // base cases, when idx over the length, that means all chars in the String have been matched
        if (idx == word.length()) {
            return true;
        }
        
        // Don't forget check the duplication
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
        // visited to avoid cycle
        visited[i][j] = true;
        boolean flag = dfs(board, word, idx + 1, i + 1, j, visited) || dfs(board, word, idx + 1, i, j + 1, visited) || dfs(board, word, idx + 1, i, j - 1, visited) || dfs(board, word, idx + 1, i - 1, j, visited);
        visited[i][j] = false;
        return flag;
    }
}