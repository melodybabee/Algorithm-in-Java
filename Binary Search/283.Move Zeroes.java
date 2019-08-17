//Solution 1:
// Make all non-zero elements to the front, then add 0 at the end
// To keep the raletive order
// O(n)
class Solution {
    public void moveZeroes(int[] nums) {
        // Corner cases
        if (nums == null) return;
        int start = 0;
        for (int i = 0 ; i < nums.length; ++i){
            if (nums[i] != 0) {
                nums[start++]  = nums[i];
            }
        }
        while (start < nums.length) {
            nums[start++] = 0;
        }
    }
}

// Optimize
// start means the first one which is 0 in the currently array
// O(n)
class Solution {
    public void moveZeroes(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) return;
        
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(i,start,nums);
                ++start;
            }
        }
    }
    
    private void swap (int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
