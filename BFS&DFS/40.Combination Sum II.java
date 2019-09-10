// One element can only be used in one time. but the list will have duplications.
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Corner casers
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> sol = new ArrayList<Integer>();
        dfs(candidates, target, result, sol, 0);
        return result;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> sol, int index) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(sol));
            return;
        }
        if(target < 0) {
            return;
        }
        for (int i = index ; i < candidates.length; ++i) {
            // Notice the meaning of i and the meanung of index, index is the standard position, and i will keep moving, so that could identify whether leave or not
            // [1,1,2,2,3] target is 1, output is [1,1,3],[1,2,2],[2,3]
            if (i > index && candidates[i] == candidates[i-1]) continue;
            sol.add(candidates[i]);
            dfs(candidates, target-candidates[i], result, sol, i + 1);
            sol.remove(sol.size() - 1);
        }
    }
}