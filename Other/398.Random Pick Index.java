class Solution {
    int res = -1;
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            this.nums[i] = nums[i];
        }
    }
    
    public int pick(int target) {
        int count = 0;
        for (int i = 0 ; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++count;
                if (res == -1) {
                    res = i;
                } else {
                    Random rand = new Random();
                    int k = rand.nextInt(count);//[0,count-1];
                    // make it with the same possibility to get the index
                    if (k == 0) {
                        res = i;
                    }
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */