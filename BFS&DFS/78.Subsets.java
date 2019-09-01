// DFS 1
/*
level: the number of nums
col: the number from the current position to the end 
return answer: once to the dfs, return one answer
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> sol = new ArrayList<Integer>();
        dfs(nums, result, sol, 0);
        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> sol,int level) {
    	// deep copy, if for array, there is .clone() or Arrays.copyOf()
        result.add(new ArrayList<Integer>(sol));
        for (int i = level; i < nums.length; ++i) {
            sol.add(nums[i]);
            dfs(nums, result, sol, i + 1);
            sol.remove(sol.size()-1);
        }
    }
}

// DFS 2
/*
level: the number of nums
col: choose or not coose 
return answer: once level == nums.length, reaching the last level
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, result, 0, new ArrayList<Integer>());
        
        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, int level, List<Integer> sol) {
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(sol));
            return;
        }
        
        sol.add(nums[level]);
        dfs(nums, result, level + 1, sol);
        sol.remove(sol.size() - 1);
        //two options, do two times recursion
        dfs(nums, result, level + 1, sol);
    }
    
}