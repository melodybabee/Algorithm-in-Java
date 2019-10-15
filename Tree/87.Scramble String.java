class Solution {
    public boolean isScramble(String s1, String s2) {
        // Corner cases
        int lens1 = s1.length();
        int lens2 = s2.length();
        if (lens1 != lens2) return false;
        if (!isSame(s1, s2)) {
            return false;
        }
        return dfs(s1, s2);
    }

    private boolean dfs(String s1, String s2){
        // Totally the same
        if (s1.equals(s2)) {
            return true;
        }
        // [0] == [1] && [1] == [0] is ok for reversion
        if (s1.length() == 2 && s2.length() == 2 && s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0)) {
            return true;
        }
        // Patation to two parts in a string, seperate it into two parts
        for (int i = 0; i < s1.length() -1; ++i) {
            String s11 = s1.substring(0, i + 1);
            String s12 = s1.substring(i+1);
            String s21 = s2.substring(0, i + 1);
            String s22 = s2.substring(i+1);
            if (isSame(s11, s21) && isSame(s12,s22) && dfs(s11,s21) && dfs(s12,s22)) {
                return true;
            }
            s21 = s2.substring(0, s2.length() - i - 1);
            s22 = s2.substring(s2.length() - i -1);
            if (isSame(s11, s22) && isSame(s12, s21) && dfs(s11, s22) && dfs(s12, s21)) {
                return true;
            }
            
        }
        return false;
    }
    
    // Two strings have the same letters
    private boolean isSame(String str1, String str2) {
        int len = str1.length();
        int[] arr = new int[26];
        //v identify whether they are the same could do the ++ and -- at the same time.
        for (int i = 0; i < len; ++i) {
            int index = str1.charAt(i) - 'a';
            ++arr[index];
            
            index = str2.charAt(i) - 'a';
            --arr[index];
        }
        for (int i = 0; i < 26; ++i) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
}