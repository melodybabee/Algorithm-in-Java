class Solution {
    public int majorityElement(int[] nums) {
        // Corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Find the sum of each digit, count the times of each digits that have appeared
        int[] counter = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; ++i) {
                counter[i] += (num & 1);
                num >>= 1;
            }
        }
        // If the time is larger than length/2, then the majority will include this digit
        int val = 0;
        for (int i = 0; i < 32; ++i) {
            if (counter[i] > nums.length/2) {
                val += (1 << i);
            }
        }
        return val;
    }
}