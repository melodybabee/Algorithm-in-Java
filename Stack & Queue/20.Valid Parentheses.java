class Solution {
    public boolean isValid(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                st.push(c);
            } else if (isRight(c)) {
                if (st.isEmpty()) {
                    return false;
                } 
                
                if (!isMatch(c,st.pop())) return false;
            }
        }
        return st.isEmpty();
    }
    
    private boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    private boolean isRight(char c) {
        return c == ')' || c == '}' || c == ']';
    }
    
    private boolean isMatch(char c, char out) {
        return (c == ')' && out == '(') || (c == '}' && out =='{') || (c == ']' && out == '[');
    }
}