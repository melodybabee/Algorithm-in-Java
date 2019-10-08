class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // Use set to remove duplication
        HashSet<String> res = new HashSet<>();
        int left = 0;
        int right = 0;
        // Count the number of left and right that need to be removed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++left;
            } else if (c == ')') {
                if (left != 0) {
                    --left;
                } else {
                    ++right;
                }
            }
        }
        StringBuilder path = new StringBuilder();
        dfs(res, path, s, 0, left, right, 0);
        return new ArrayList<String>(res);
    }
    
    private void dfs(HashSet<String> res, StringBuilder path, String s, int index, int left, int right, int delta) {
        if (index == s.length() && left == 0 && right == 0 && delta == 0) {
            res.add(path.toString());
            return;
        }
        if (index >= s.length() || left < 0 || right < 0 || delta < 0) {
            return;
        }
        char c = s.charAt(index);
        int len = path.length();
        if (c == '(') {
            // remove
            dfs(res, path, s, index + 1, left - 1, right, delta);
            //keep
            path.append(c);
            dfs(res, path, s, index + 1, left, right, delta + 1);
            path.setLength(len);
        } else if (c == ')') {
            // remove
            dfs(res, path, s, index + 1, left, right - 1, delta);
            //keep
            path.append(c);
            int i = index + 1;
            dfs(res,path, s, index + 1, left, right, delta - 1);
            path.setLength(len);
        } else {
            path.append(c);
            dfs(res,path, s, index + 1, left, right, delta);
            // Always set back
            path.setLength(len);
        }
    }
}