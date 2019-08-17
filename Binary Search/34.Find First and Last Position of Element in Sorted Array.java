// Solution 1, find the left edge and find right from the left
// O(logN) + O(K), badest O(N)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Corner Cases
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        int start = -1;
        int end = -1;
        while (left + 1 < right){
            mid = left + (right-left)/2;
            
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] == target) {
            start = left;
        } else if (nums[right] == target) {
            start = right;
        } else {
            return new int[]{-1,-1};
        }
        
        end = start;
        for (int i = start+1; i < nums.length; ++i) {
            if (nums[i] == nums[start]) {
                end = i;
            }
        }
        return new int[]{start,end};
    }
}

// Solution2 find the left and right directly using binary search
// The trick is return num, for instance, using  while(left <= right), should identify the left index value. so let the right side close to the left one.
// so should judge whether left side out of edge and whether array[left] = target.
// O(logN) + O(logN) = O(logN);
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Corner cases
        if (nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        
        int start = searchFirstPosition(nums, target);
        int end = searchLastPosition(nums, target);
        
        return new int[]{start,end};
    }
    
    private int searchFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        
        while(left <= right) {
            mid = left + (right-left)/2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return (left == nums.length || nums[left] != target) ? -1 : left;
    }
    
    private int searchLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        
        while(left <= right) {
            mid = left + (right-left)/2;
            
            if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return (right == -1 || nums[right] != target) ? -1 : right;
    }
}