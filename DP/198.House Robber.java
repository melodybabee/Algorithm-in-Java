class Solution {
    public int rob(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // The status just before the nums
        int sum1 = nums[0];
        // The status before the sum1
        int sum2 = 0;
        for (int i = 1; i < nums.length; ++i) {
            int temp = sum2 + nums[i];
            sum2 = Math.max(sum1, sum2);
            sum1 = temp;
        }
        return Math.max(sum1,sum2);
    }
}