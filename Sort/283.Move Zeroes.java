// Solution1 iteration and swap
/*
key point: in java, the swap method should be written as
private void swap(int num1, int num2, int[] nums) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
If there is no original int[] array, the properties will be the copy of original value. which will not change the original value.
*/
// start should be iterated one by one, start will be the position of 0.
// It there is no 0 at first, start will be swapped for every time and move forword +1. if there is 0, start will stop and i will keep going.
// T(n) = O(n), S(n) = O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0){
            return;
        }
        
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0){
                swap(start,i,nums);
                ++start;
            }
        }
        return;
    }
    
    private void swap(int num1, int num2, int[] nums) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}

// Solution 2
/*
start will be the pointer that all value before it is non-zero, start will start at 0 position, in order to get new value
when i till the end of the array, add 0 in the last part
*/
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