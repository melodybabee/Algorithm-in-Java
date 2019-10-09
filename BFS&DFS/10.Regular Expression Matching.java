// DFS
// * will repeat the char before it, so that * will not at the first position of the String
// so that we should identify whether i + 1 is *
class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p ,0);
    }
    
    private boolean dfs(String s, int idxs, String p, int idxp) {
        int lens = s.length();
        int lenp = p.length();
    
        if (idxp == lenp) {
            return idxs == lens;
        }
        // with ., no * in i + 1, so that just compare whether they are the same or s == .
        if (idxp == lenp - 1 || p.charAt(idxp + 1) != '*') {
            if (idxs < lens && (s.charAt(idxs) == p.charAt(idxp) || p.charAt(idxp) == '.')) {
                return dfs(s, idxs + 1, p , idxp + 1);
            } else {
                return false;
            }
        } else {  // with *
        	// start from the 0 position, in case s = "aab", p = "c*a*b"
        	// If s == p or p == . that means match successfully, so that could continue the match process
            int i = idxs - 1;
            while (i < lens && (i < idxs || s.charAt(i) == p.charAt(idxp) || p.charAt(idxp) == '.')) {
                if (dfs(s, i + 1, p , idxp + 2)) {
                    return true;
                }
                ++i;
            }
            return false;
        }
    }
}

// DFS with memorazation, also based on dfs, recursion first then recording the recursion result
class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        // Avoid the bound overflow, if Boolean, should set false
        Boolean[][] mem = new Boolean[lens + 1][lenp + 1];
        // If boolean, the default is false, so no need to set false
        boolean[][] mem = new boolean[lens + 1][lenp + 1];
        return dfs(s, 0, p ,0, mem);
    }
    
    private boolean dfs(String s, int idxs, String p, int idxp, Boolean[][] mem) {
        int lens = s.length();
        int lenp = p.length();
    
    	// because the idxs and idxp will be equls to lens and lenp, it is bigger than the string, so that the boolean array will be larger than the string
        if (mem[idxs][idxp] != null) {
            return mem[idxs][idxp];
        }
        if (idxp == lenp) {
            return idxs == lens;
        }
        // with .
        if (idxp == lenp - 1 || p.charAt(idxp + 1) != '*') {
            if (idxs < lens && (s.charAt(idxs) == p.charAt(idxp) || p.charAt(idxp) == '.')) {
                mem[idxs][idxp] = dfs(s, idxs + 1, p , idxp + 1, mem);
            } else {
                mem[idxs][idxp] = false;
                return false;
            }
        } else {  // with *
            int i = idxs - 1;
            while (i < lens && (i < idxs || s.charAt(i) == p.charAt(idxp) || p.charAt(idxp) == '.')) {
                if (dfs(s, i + 1, p , idxp + 2, mem)) {
                    mem[idxs][idxp] = true;
                    return true;
                }
                ++i;
            }
            mem[idxs][idxp] = false;
        }
        return mem[idxs][idxp];
    }
}

// DP
class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        if (lenp == 0) return lens == 0;
        Boolean[][] dp = new Boolean[lens + 1][lenp + 1];
        // Should init dp to default false
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = false;
            }
        }
        dp[lens][lenp] = true;
        
        // To deal with * match 0 times, like a and ab*, there * matches 0 time
        int k = lenp - 2;
        while(k >= 0) {
            if (p.charAt(k + 1) == '*') {
                dp[lens][k] = true;
            } else {
                break;
            }
            k -= 2;
        }
        
        for (int i = lens - 1; i >= 0; --i) {
            for (int j = lenp - 1; j >= 0; --j) {
                if (p.charAt(j) == '*') {
                    continue;
                }
                // no *
                if (j == lenp - 1 || p.charAt(j + 1) != '*') {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {// when the next one is *
                    int idx = i - 1;
                    while (idx < lens && (idx < i || p.charAt(j) == '.' || p.charAt(j) == s.charAt(idx))) {
                        if (dp[idx + 1][j + 2]) { // start from dp[i][j + 2]
                            dp[i][j] = true;
                            // once matched, it can break
                            break;
                        }
                        ++idx;
                    }
                }
            }
        } 
            
        return dp[0][0];
    }
}

// DFS with pruning, use a Boolean[] to record the status
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