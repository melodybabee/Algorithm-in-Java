class Solution {
    public String decodeString(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<StringBuilder> stringSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int val = 0;
        // push an empty first to avoid the empth stack
        stringSt.push(new StringBuilder());
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch <= '9' && ch >= '0') {
                val = val * 10 + (ch - '0');
            } else if (ch == '[') {
                // It is time to push the number and a empty StringBuilder
                numSt.push(val);
                stringSt.push(new StringBuilder());
                val = 0;
            } else if (ch == ']') {
                StringBuilder res = new StringBuilder();
                int n = numSt.pop();
                StringBuilder st = stringSt.pop();
                while (n-- > 0) {
                    res.append(st);
                }
                stringSt.peek().append(res);
            } else {
                stringSt.peek().append(ch);
            }
        }
        return stringSt.pop().toString();
    }
}