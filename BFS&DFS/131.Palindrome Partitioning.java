class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        // Corner cases
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> sol = new ArrayList<>();
        dfs(res, sol, s, 0);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> sol, String s, int index) {
        if (index == s.length()) {
            List<String> tempsol = new ArrayList<>(sol);
            res.add(tempsol);
        }
        
        for (int i = index + 1; i <= s.length(); ++i) {
            String str = s.substring(index, i);
            if (isPalin(str)) {
                sol.add(str);
                dfs(res, sol, s, i);
                sol.remove(sol.size() -1);
            }
        }
    }
    
    private boolean isPalin(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            char l = str.charAt(left);
            char r = str.charAt(right);
            if (l != r) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}