// Time O(N), space O(1)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        // idx1 and idx2 record the last index of the distinct characters
        int idx1 = -1;
        int idx2 = -1;
        int res = 0;
        int start = 0;
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            if (idx1 == -1 || ch == s.charAt(idx1)) {
                idx1 = i;
            } else if (idx2 == -1 || ch == s.charAt(idx2)) {
                idx2 = i;
            } else { // if it is the third character
                if (idx1 < idx2) {
                    // Update the start first, start from the smaller one + 1
                    start = idx1 + 1;
                    idx1 = i;
                } else {
                    start = idx2 + 1;
                    idx2 = i;
                }
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}