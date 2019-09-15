// Solution 1: confirm the length of target String
class Solution {
    public int strStr(String haystack, String needle) {
        // Corner cases
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; ++i) {
            String str = haystack.substring(i, len+i);
            if (str.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

// Solution 2: Two pointers
class Solution {
    public int strStr(String haystack, String needle) {
        // Corner cases
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; ++i) {
            int j;
            for (j = 0; j < needle.length(); ++j) {
            	// stand on the base of i
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}