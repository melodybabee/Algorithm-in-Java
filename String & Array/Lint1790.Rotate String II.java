// reverse method
// also can get substring and make concat, A.concat(B), 拼接起来
public class Solution {
    /**
     * @param str: An array of char
     * @param left: a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // write your code here
        // Corner cases
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int temp = right - left;
        temp %= str.length();
        System.out.println(temp);
        if (temp > 0) {
            reverse(chars, 0, chars.length - temp - 1);
            reverse(chars, chars.length - temp, chars.length - 1);
            reverse(chars, 0, chars.length - 1);
        } else if (temp < 0) {
            reverse(chars, 0, -temp - 1);
            reverse(chars, -temp, chars.length - 1);
            reverse(chars, 0, chars.length - 1);
        }
        return new String(chars);
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