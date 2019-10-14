// T(n) = O(N^3);
class Solution {
    public int minCut(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            // For we want the min, so that init it to the possible biggest
            dp[i] = s.length() - 1;
            for (int j = 0; j <= i; ++j) {
                String str = s.substring(j,i + 1);//[j,i]
                if (isPalin(str)) {
                    // The former status is dp[j-1];
                    dp[i] = Math.min(dp[i], j == 0 ? 0: dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }
    
    private boolean isPalin(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            char l = str.charAt(left);
            char r = str.charAt(right);
            if (l != r) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}

// DP, O(N^2)
class Solution {
    public int minCut(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        // Use palin to check palindrome
        boolean[][] palin = new boolean[len][len];
        for (int i = len - 1; i >= 0; --i){
            dp[i] = len - i;
            for (int j = i; j < len; ++j) {
                if (i == j ||  (s.charAt(i) == s.charAt(j) && (palin[i+1][j-1] || j == i + 1))) { // [i,j] is palindrome
                    palin[i][j] = true;
                    // Will use the dp[i + 1] as initialized
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        // From the tail to the top
        return dp[0] - 1;
    }
}
