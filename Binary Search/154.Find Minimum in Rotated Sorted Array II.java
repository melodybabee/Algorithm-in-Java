// if array[left] == array[right], left = left + 1, in order to confirm the ascending range
/*
The condition when entering the while loop is left + 1 < right, then after moving left side, should confirm where left and right is
then find the valley, there is possible that array[mid] == array[right], so that need "="
*/
class Solution {
    public int findMin(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        while (left + 1 < right) {
            while (left < right && nums[left] == nums[right]) {
                ++left;
            }
            if (left == right) {
                return nums[left];
            }
            
            mid = left + (right-left)/2;
            
            if (nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}