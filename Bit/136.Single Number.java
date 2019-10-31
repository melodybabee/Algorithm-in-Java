class Solution {
    public int singleNumber(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        // Some appears 2 times, one appear 1 time.
        // If they are the same, ^= will be 0, or be 1, so that the left one is the res.
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}