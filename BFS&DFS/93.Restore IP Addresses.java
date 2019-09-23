// Four levels tree with three branchs
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, s, 0, 0, sb);
        return res;   
    }
    
    private void dfs(List<String> res, String s, int num, int index, StringBuilder sb) {
        if (num == 4) {
            if (index == s.length()) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            }
            // Cutting here, if num > 4, also return
            return;
        }
        // Split in 3 parts to add '.'
        for(int i = 1; i <= 3; ++i) {
            if (index + i > s.length()) break;
            // Integer.parseInt() to parse String to Integer directly
            // Or Integer.valueOf(s.substring(index, index + i));
            int val = Integer.parseInt(s.substring(index, index + i));
            if (val <= 255) {
                int len = sb.length();
                sb.append(val + ".");
                dfs(res, s, num + 1, index + i, sb);
                sb.setLength(len);
            }
            // "012" is invalid, when meet 0, 0 must be individual
            if (val == 0){
                break;
            }
        }
    }
}