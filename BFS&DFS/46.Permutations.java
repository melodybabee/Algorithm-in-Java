// Solution 1 swap + DFS
/* input: 123, output is
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(result, nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, int level) {
        if (level == nums.length -1) {
        	// change array to list, the Arrays.toList() return a List with non-changable length list, cannot use add/ remove/ ...
        	// and if the arrar is including the primitive type, will add the first one, not everyone. Should use Objext instead
            result.add(arrayToList(nums));
            return;
        }
        for (int i = level; i < nums.length; ++i) {
            swap(nums, i ,level);
            dfs(result, nums, level + 1);
            swap(nums, i, level);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    private List<Integer> arrayToList(int[] nums){
        List<Integer> res = new ArrayList<Integer>();
        for (int i : nums) {
            res.add(i);
        }
        return res;
    }
}