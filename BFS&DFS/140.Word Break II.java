// DFS, TLE
/*
Example:
aaaaaaaaaaaaa
[a, aa, aaa, aaaa, ......]
*/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        // Corner cases
        if (s == null || s.length() == 0) {
            return res;
        }
        HashSet<String> dic = new HashSet<>();
        for (String str: wordDict) {
            dic.add(str);
        }
        StringBuilder path = new StringBuilder();
        dfs(res, path, s, 0, dic);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder path, String s, int index, HashSet<String> dic) {
        if (index == s.length()) {
            res.add(path.toString());
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            // Get the substring, start position is index and it ends at i + 1, substring[)
            String str = s.substring(index, i + 1);
            int len = path.length();
            if (dic.contains(str)) {
            	// Deal with the space condition
                if (path.length() == 0) {
                    path.append(str);
                } else {
                    path.append(" " + str);
                }
                // the new string starts from i + 1
                dfs(res, path, s, i + 1, dic);
                path.setLength(len);
            }
        }
    }
}

// DFS with pruning, use a flag to record the status of a positon that whether it can reach the end or not
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        // Corner cases
        if (s == null || s.length() == 0) {
            return res;
        }
        HashSet<String> dic = new HashSet<>();
        for (String str: wordDict) {
            dic.add(str);
        }
        boolean[] mem = new boolean[s.length() + 1];
        // the default is all true
        Arrays.fill(mem, true);
        StringBuilder path = new StringBuilder();
        dfs(res, path, s, 0, dic, mem);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder path, String s, int index, HashSet<String> dic, boolean[] mem) {
        if (index == s.length()) {
            res.add(path.toString());
            return;
        }
        int size = res.size();
        for (int i = index; i < s.length(); ++i) {
            String str = s.substring(index, i + 1);
            int len = path.length();
            if (dic.contains(str) && mem[i+1]) {
                if (path.length() == 0) {
                    path.append(str);
                } else {
                    path.append(" " + str);
                }
                dfs(res, path, s, i + 1, dic, mem);
                path.setLength(len);
            }
        }
        // If the result doesn't change, it means that searching fails.
        if (res.size() == size) {
            mem[index] = false;
        }
    }
}