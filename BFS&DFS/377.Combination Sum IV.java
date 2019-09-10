class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Corner cases
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        for (int i = 1; i < dp.length; ++i) {
            for(int num : nums) {
                if (num == i) {
                    dp[i] += 1;
                } else if (num > i) {
                    break;
                } else {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}