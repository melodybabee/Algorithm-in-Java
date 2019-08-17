/* The difference between 33 and 81 is whether has the same elements. so it will make [1,2,3,4,1,1,1,1,1], array[left] == array[mid] == array[right], and we cannot identify to move to which side.
So when this situation happens, as array[left] == array[right], we should move left/right to the middle. Then find mid position once more time.
Then it is the same as 33.
*/
// The badest is O(n), and in average is O(logN);
class Solution {
    public boolean search(int[] nums, int target) {
        // Corner Cases
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            while (left < right && nums[left] == nums[right]){
                ++left;
            }
            mid = left + (right-left)/2;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                 if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return false;
    }
}