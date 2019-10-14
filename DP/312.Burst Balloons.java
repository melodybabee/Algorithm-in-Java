class Solution {
    public int maxCoins(int[] nums) {
        // Corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len]; 
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                int max = 0;
                for (int k = i; k <= j; ++k) {
                    int val = 0;
                    // 
                    val += (k == i ? 0 : dp[i][k-1]);
                    val += (k == j ? 0 : dp[k+1][j]);
                    // The last value, times the k and its left and its right
                    val += nums[k] * (i == 0 ? 1: nums[i-1]) * (j == (len -1) ? 1 : nums[j+1]);
                    max = Math.max(max, val);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][len - 1];
    }
}
/*
[3, 30, 159,167]
[0,15,135,159]
[0,0,40,48]
[0,0,0,40]
*/