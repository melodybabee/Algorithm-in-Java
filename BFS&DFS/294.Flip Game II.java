// DFS
class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return dfs(s.toCharArray());  
    }
    
    private boolean dfs(char[] str) {
        for (int i = 0; i < str.length - 1; ++i) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = '-';
                str[i + 1] = '-';
                boolean temp = dfs(str);
                // Wrong because for every recursion time, the set back process must be finished when return to the formal level
                //if (!temp) return true;
                str[i] = '+';
                str[i + 1] = '+';
                if (!temp) return true;
            }
        }
        return false;
    }
}

// DFS with pruning
class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>();
        return dfs(s.toCharArray(), map);  
    }
    
    private boolean dfs(char[] str, HashMap<String, Boolean> map) {
        Boolean ret = map.get(String.valueOf(str));
        if (ret != null) {
            return ret;
        }
        for (int i = 0; i < str.length - 1; ++i) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = '-';
                str[i + 1] = '-';
                boolean temp = dfs(str, map);
                map.put(String.valueOf(str),temp);
                str[i] = '+';
                str[i + 1] = '+';
                if (!temp) return true;
            }
        }
        map.put(String.valueOf(str),false);
        return false;
    }
}

// DFS + HashSet pruning, when true add to set
class Solution {
    public boolean canWin(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        return dfs(s.toCharArray(), set);
    }
    
    private boolean dfs(char[] s, HashSet<String> set) {
        if (set.contains(String.valueOf(s))) {
            return true;
        }
        for (int i = 0; i < s.length - 1; ++i) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                boolean temp = dfs(s, set);
                s[i] = '+';
                s[i + 1] = '+';
                if (!temp) {
                    set.add(String.valueOf(s));
                    return true;
                }
            }
        }
        return false;
    }
}