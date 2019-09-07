// first reverse by word, and then reverse the whole string
public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        // Corner cases
        if (str == null || str.length == 0) {
            return;
        }
        if (offset == 0) return;
        offset %= str.length;
        
        // the length should start from the end
        // reverse(char[], int startindex, int endindex);
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
        return;
    }
    
    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
            ++start;
            --end;
        }
        return;
    }
}