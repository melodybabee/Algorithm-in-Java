class Solution {
    public int numDistinct(String s, String t) {
        // Corner case
        if (s == null || t == null) {
            return 0;
        }
        int lens = s.length();
        int lent = t.length();
        int[][] dp = new int[lens + 1][lent + 1];
        
        for (int i = 0; i <= lens; ++i) {
            // Null string will be the 1
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= lens; ++i) {
            for (int j = 1; j <= lent; ++j) {
                // If not match, ignore this position and the result is the same as the formal one
                // abccx and abc, when i == 'x'
                if (s.charAt(i -1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j];
                // if i equals to j, then I could choose match or not match
                // abcc and abc, match [abc] and [ab], or not match, [abc] and [abc]
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[lens][lent];
    }
}