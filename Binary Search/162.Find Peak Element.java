/*find the peak should compare mid-1 and mid+1
mid - 1 and mid +1 are always existed becauze the while condition is at least three element, so the mid one will always be in the middle
when left + 1 == right, it will not enter the while loop*/

// O(n) = O(logN)
class Solution {
    public int findPeakElement(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right-left)/2;
            
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid] < nums[mid-1]){
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return nums[left] > nums[right] ? left : right;
    }
}