// Time: O(N), space: O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Corner cases
        int len = nums.length;
        if (len < 3) return false;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            if (res.isEmpty()) {
                res.add(nums[i]);
            } else if (nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                if (nums[i] < res.get(0)) {
                    res.set(0, nums[i]);
                } else if (nums[i] > res.get(0) && nums[i] < res.get(1)) {
                    res.set(1, nums[i]);
                }
            }
            
            if (res.size() >= 3) {
                return true;
            }
        }
        return false;
    }
}