class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // Sort firstly
        Arrays.sort(nums);
        List<Integer> sol = new ArrayList<>();
        dfs(res, sol, nums, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> sol, int[] nums, int index) {
        res.add(new ArrayList<Integer>(sol));
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            sol.add(nums[i]);
            dfs(res, sol, nums, i + 1);
            sol.remove(sol.size() - 1);
        }
    }
}