/*
seperate 0, 1, 2
Do the loop of this array, if it equals 0, swap cur one with the first one
if it equls 2, swap cur one with the last one.
if it equals 1, keep cur pointer ++
NOTICE: when the cur node has swapped with the end one, should be confirm again. In other works, cannot use cur++ directly.
Because if cur meets 2, it will alway swap with the end. The value of the end should do while loop again.
And when it meets 0, the node's value before it is 0 or 1, no 2, so that it could be ++cur and move to the next position.

*/
class Solution {
    public void sortColors(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int cur = 0;
        while (cur <= end) {
            if (nums[cur] == 0) {
                swap(start,cur,nums);
                ++start;
                ++cur;
            } else if(nums[cur] == 2){
                swap(cur,end,nums);
                --end;
            } else {
                ++cur;
            }
        }
        return;
    }
    
    private void swap (int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }
}