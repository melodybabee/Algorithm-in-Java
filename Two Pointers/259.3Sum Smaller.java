class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        // Corner cases
        if (nums == null || nums.length == 0) {
            return count;
        }
        // need consecutive  so that need sorted
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int tempTarget = target - nums[i];
            int left = i + 1;
            int right = nums.length -1;
            // Use two pointers to devide it into two parts
            while (left < right) {
                if (nums[left] + nums[right] < tempTarget) {
                    // the left pointer is the standard and move the right side
                    count += right -left;
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return count;
    }
}