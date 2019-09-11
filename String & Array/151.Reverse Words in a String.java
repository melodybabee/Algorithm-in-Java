class Solution {
    public String reverseWords(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] charArray = s.toCharArray();
        // reverse whole char array
        reverse(charArray, 0, charArray.length-1);
        // reverse word by word
        int start = 0;
        int slow = 0;
        for (start = 0; start < charArray.length; ++start) {
            if (charArray[start] == ' '){
            	
                reverse(charArray, slow, start - 1);
                slow = start + 1;
            }
        }
        // Notice this part should reverse the last word
        reverse(charArray, slow, charArray.length - 1);
        // clean the space
        return deleteSpace(charArray);   
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            ++start;
            --end;
        }
    }
    
    private String deleteSpace(char[] charArray) {
        int slow = 0;
        for (int i = 0; i < charArray.length; ++i) {
            // Notice the order of (i == 0 || charArray[i-1] == ' ')
            if (charArray[i] == ' ' && (i == 0 || charArray[i-1] == ' ')) {
                continue;
            }
            charArray[slow] = charArray[i];
            ++slow;
        }
        if (slow == 0) return new String();
        return charArray[slow-1] == ' ' ? new String(charArray, 0, slow - 1) :new String(charArray, 0, slow);
    }
}
