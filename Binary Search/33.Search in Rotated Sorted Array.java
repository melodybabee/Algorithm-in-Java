/*
Because it is rotated, so we should find the ascending part of this array.
At least one of the left part and the right part will be in order.
THen find the target in the ordered part, and move the left/right pointer.
*/

// if ... else ... must be used in the complementary relationship, or will ignore some parts. Because the consition in while loop includes equals, so that left == mid/mid == right will happen.
// if  (nums[mid] < nums[right]) else if  (nums[mid] > nums[left]) will fail in [4,5,6,7,0,1,2] to find 3, finally, left = right = mid = array[4] = 0, but it doesn't satisfy each situation
// if (target > nums[mid] && target <= nums[right], target will not equals to mid but it may equals to left/right, so dont forget "="
// O(logN)
class Solution {
    public int search(int[] nums, int target) {
        // Corner cases
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        while (left <= right) {
            mid = left + (right-left)/2;
           
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}