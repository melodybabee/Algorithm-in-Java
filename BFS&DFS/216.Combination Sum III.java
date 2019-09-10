class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        dfs (result, sol, k, n, 1);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> sol, int k, int n, int start) {
        if (sol.size() == k && n == 0) {
            // For reference type should use deep copy, but if it is primitive type, it is will be a global total sum to record, or will copy a new one for every time
            result.add(new ArrayList<Integer>(sol));
            return;
        }
        if (sol.size() > k || n < 0) {
            return;
        }
        // Notice from 1 to 9
        for (int i = start; i <= 9 ; ++i) {
            sol.add(i);
            // the recursion will start from cur postion, which is i, not start
            dfs(result, sol, k, n - i, i + 1);
            sol.remove(sol.size() -1);
        }
    }
}