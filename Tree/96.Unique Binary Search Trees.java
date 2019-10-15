// DFS in #95 is ok, but TLE. Because we would like to get a single result, could use mem or dp to improve
// The purpose of dp is to let the current node as root, and find all possible answers of left nodes and right nodes
class Solution {
    public int numTrees(int n) {
        // Corner cases
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // Null node is the only option 
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            int count = 0;
            for (int j = 0; j < i; ++j) {
                // leave one node as root
                count += dp[j] * dp[i - j - 1];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}