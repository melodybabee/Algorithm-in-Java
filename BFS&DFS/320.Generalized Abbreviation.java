class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, 0, 0, word);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, int count, int index, String word) {
        // Use a count to record the process currently
        if (index == word.length()) {
            if (count > 0) {
                sb.append(count);
            }
            res.add(sb.toString());
            return;
        }
        char c = word.charAt(index);
        int len = sb.length();
        // For every position, it can be digit or a number.
        // number
        dfs(res, sb, count + 1, index + 1, word);
        sb.setLength(len);
        
        // char
        if (count > 0) {
            sb.append(count);
            count = 0;
        }
        sb.append(c);
        dfs(res, sb, count, index + 1, word);
        sb.setLength(len);
        
    }
}