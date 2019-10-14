class Solution {
    public int minDistance(String word1, String word2) {
        // Corner cases
        if (word1 == null && word1 == null) return -1;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; ++i) {
            dp[0][i] = i;
        }
        
        // Should touch the edge of the array, the index is always the edge -1
        // For loop the edge of the 2D array
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                // And the index of word is equals to the index of DP - 1
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int addLetter = dp[i-1][j] + 1;
                    int deleteLetter = dp[i][j-1] + 1;
                    int replaceLetter = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(addLetter, Math.min(deleteLetter, replaceLetter));
                }
            }
        }
        return dp[len1][len2];
    }
}