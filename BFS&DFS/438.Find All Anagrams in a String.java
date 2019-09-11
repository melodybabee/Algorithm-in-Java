class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return result;
        }
        int len = p.length();
        // find substring
        for(int i = 0; i <= s.length() - len; ++i) {
            String str = s.substring(i, i + len);
            if (isAnagram(str, p)) {
                result.add(i);
            }
        }
        return result;
    }
    
    // If use sort will be time exceed, so use int[26].
    // The letter is usually letter - 'a';
    private boolean isAnagram(String str, String p) {
        int[] check = new int[26];
        for (char c : str.toCharArray()) {
            ++check[c - 'a'];
        }
        
        for (char c : p.toCharArray()) {
            --check[c - 'a'];
        }
        for (int i = 0; i < check.length; ++i) {
            if (check[i] != 0) {
                return false;
            }
        }
        return true;
    }
}