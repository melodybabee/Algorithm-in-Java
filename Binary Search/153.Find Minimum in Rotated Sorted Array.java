// find the valley of the array
//  O(logN)
class Solution {
    public int findMin(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left + 1<right) {
            mid = left + (right-left)/2;
            
            if (nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return nums[left] < nums[right] ? nums[left]: nums[right];
    }
}