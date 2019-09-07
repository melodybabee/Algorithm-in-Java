class Solution {
    public void reverseWords(char[] s) {
        // Corner cases
        if (s == null || s.length == 0) {
            return;
        }
        // reverse the whole string
        reverse(s, 0, s.length -1);
        
        // reverse word by word
        int slow = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == ' ') {
                reverse(s, slow ,i-1);
                slow = i + 1;
            }
        }
        reverse(s, slow, s.length - 1);
        
        return;
    }
    
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            ++start;
            --end;
        }
    }
}