class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        // Corner cases
        if (num == null || num.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, String num, int index, int target, long sum, long curVal) {
        //System.out.println(sb);
        if (index == num.length() && sum == target) {
            res.add(sb.toString());
            return;
        }
        
        if (index > num.length()) {
            return;
        }
        // Use long to avoid overflow
        long val = 0;
        // for loop do the traverse of the string, add operation or not
        for (int i = index; i < num.length(); ++i) {
            val = val * 10 + (num.charAt(i) - '0');
            if (sb.length() == 0) {
                sb.append(val);
                dfs(res, sb, num, i + 1, target, val, val);
                // Set back for 12*3 case (for example). There maybe no operators between two digits.
                sb.setLength(0);
            } else {
                // Seperate to three directions
                int length = sb.length();
                // +
                sb.append("+" + val);
                dfs(res, sb, num, i + 1, target, sum + val, val);
                sb.setLength(length);
                // -
                sb.append("-" + val);
                dfs(res, sb, num, i + 1, target, sum - val, -val);
                sb.setLength(length);
                // *
                sb.append("*" + val);
                dfs(res, sb, num, i + 1, target, (sum - curVal) + (curVal * val), curVal * val);
                sb.setLength(length);
            }
            // if value == 0, cannot ingore 0 and continue do the for loop, so break
            if (val == 0) break;
        }
    }
}