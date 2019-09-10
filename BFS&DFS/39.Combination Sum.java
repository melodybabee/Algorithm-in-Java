// in each sublist, there will be duplicate elements
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner cases
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        // array sorts using Arrays.sort(), reference type using Collections.sort()
        Arrays.sort(candidates);
        if(candidates[0] > target) return result;
        
        List<Integer> sol = new ArrayList<Integer>();
        dfs(candidates, target, sol, 0, result);
        return result;
    }
    
    private void dfs(int[] candidates, int target, List<Integer> sol, int start, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(sol));
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; ++i) {
            sol.add(candidates[i]);
            // recursion starts from i
            dfs(candidates, target - candidates[i], sol, i, result);
            sol.remove(sol.size() - 1);
        }
    }
}