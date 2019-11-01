class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            this.nums[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    // Shuffle one by one
    public int[] shuffle() {
        int[] res = new int[this.nums.length];
        int len = res.length;
        for (int i = 0 ; i < len; ++i) {
            Random rand = new Random();
            int idx = rand.nextInt(i+1);
            res[i] = res[idx];
            res[idx] = nums[i];
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */