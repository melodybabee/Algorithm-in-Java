class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Corner cases
        if (s == null || s.length() == 0) {
            return 0;
        }
        // ASCII code
        int[] dic = new int[256];
        int start = 0;
        int max = 0;
        int total = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (dic[ch] == 0) {
                ++total;
            }
            ++dic[ch];
            // move the left side
            while (total > k) {
                --dic[s.charAt(start)];
                if (dic[s.charAt(start)] == 0) {
                    --total;
                }
                ++start;
            }
            max = Math.max(max, i- start+1); 
        }
        return max;
    }
}