class Solution {
    public int myAtoi(String str) {
        // Corner cases
        if (str == null || str.length() == 0) {
            return 0;
        }
        // delete the space
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            ++start;
        }
        
        // mark the '+' or '-'
        boolean flag = false;
        if (start < str.length() && str.charAt(start) == '-') {
            flag = true;
            ++start;
        } else if (start < str.length() && str.charAt(start) == '+') {
            ++start;
        }
        
        // Deal with the num
        int result = 0;
        for (int i = start; i < str.length(); ++i) {
                int num = str.charAt(i) - '0';
                if (!Character.isDigit(str.charAt(i))) {
                    break;
                } 
                // used divied rather than times, or will be overflow
                if ((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10)) {
                    return flag == true? Integer.MIN_VALUE: Integer.MAX_VALUE;
                } 
                result = 10*result + num;
        }
        return flag == true ? -result : result;
    }
}