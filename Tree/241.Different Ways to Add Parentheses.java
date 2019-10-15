// Convert String to the binary tree, like 95, 894
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        //It the string doesn't include character, should identify it
        boolean isNum = true;
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                isNum = false;
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i + 1, input.length()));
                List<Integer> one = calculate(l, r, ch);
                res.addAll(one);
            }
        }
        if (isNum) res.add(Integer.valueOf(input));
        return res;
    }
    
    private List<Integer> calculate(List<Integer> l, List<Integer> r, char ch) {
        List<Integer> sol = new ArrayList<>();
        for (Integer i : l) {
            for (Integer j : r) {
                if (ch == '+') sol.add(i + j);
                if (ch == '-') sol.add(i - j);
                if (ch == '*') sol.add(i * j);
            }
        }
        return sol;
    }
}