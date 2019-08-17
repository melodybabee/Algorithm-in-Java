// find the position, which equals to find the target position, so that while(left <= right) is more convinent.
// O(logN)
class Solution {
    public int searchInsert(int[] nums, int target) {
        // Corner cases
        if (nums == null) {
            return -1;
        }
        // if (nums.length == 0) {
        //     return 0;
        // }
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}