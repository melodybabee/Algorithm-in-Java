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



// Easy to read
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(res, path, word, 0, 0);
        return res;
    }
    
    private void dfs(List<String>res, StringBuilder path, String word, int index, int count) {
        if (index == word.length()) {
            if (count > 0) {
                path.append(count);
            }
            res.add(path.toString());
            return;
        }
        int len = path.length();
        // digit
        dfs(res, path, word, index + 1, count + 1);
        // set back to the original length
        path.setLength(len);
        // letter
        if (count > 0) {
            path.append(count);
            count = 0;
            dfs(res, path, word, index + 1, count);
            path.setLength(len);
        } else {
            path.append(word.charAt(index));
            dfs(res, path, word, index + 1, count);
            path.setLength(len);
        }
        
    }
}