// DFS, TLE
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> dic = new HashSet<>();
        for (String str: wordDict) {
            dic.add(str);
        }
        return dfs(s, 0, dic);
    }
    
    private boolean dfs(String s, int index, HashSet<String> dic) {
        if (index == s.length()) {
            return true;
        }
        for (int i = index; i < s.length(); ++i) {
            String str = s.substring(index, i + 1);
            if (dic.contains(str)) {
                if (dfs(s, i + 1, dic)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// DFS with pruning
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> dic = new HashSet<>();
        Boolean[] mem = new Boolean[s.length() + 1];
        for (String str: wordDict) {
            dic.add(str);
        }
        return dfs(s, 0, dic, mem);
    }
    
    private boolean dfs(String s, int index, HashSet<String> dic, Boolean[] mem) {
        if (index == s.length()) {
            return true;
        }
        if (mem[index] != null) {
            return mem[index];
        }
        for (int i = index; i < s.length(); ++i) {
            String str = s.substring(index, i + 1);
            if (dic.contains(str)) {
                if (dfs(s, i + 1, dic, mem)) {
                    mem[index] = true;
                    return true;
                }
            }
        }
        mem[index] = false;
        return false;
    }
}

// DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> dic = new HashSet<>();
        boolean[] mem = new boolean[s.length() + 1];
        mem[s.length()] = true;
        for (String str: wordDict) {
            dic.add(str);
        }
        // i is the start position
        for (int i = s.length() - 1; i >= 0; --i) {
        	// j is to find the substring start from i, so the init value of j is i + 1
        	// j can equals to s.length()
            for (int j = i + 1; j <= s.length(); ++j) {
                String str = s.substring(i, j);
                if (dic.contains(str)) {
                	// Not include j, if mem[j] is true, means form j to end can be found in the dictionary
                    if (mem[j]){
                        mem[i] = true;
                        break;
                    }
                }
            }
        }
        return mem[0];
    }
}

// DP 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        HashSet<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j <= s.length(); ++j) {
                String temp = s.substring(i,j);
                // This if condition must when dp[j] is true, continue. 
                if (dict.contains(temp) && dp[j]) {
                    dp[i] = dp[j];
                    // Once change false to true, break. Or if there is 
                    break;
                }
            }
        }
        return dp[0];
    }
}