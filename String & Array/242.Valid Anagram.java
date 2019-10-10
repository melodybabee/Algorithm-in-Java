class Solution {
    public boolean isAnagram(String s, String t) {
        // Corner cases
        if (s.length() != t.length()) {
            return false;
        }
        // As for the string that only contains lowercase letter
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            ++count[c - 'a'];
        }
        
        for (char c: t.toCharArray()) {
            --count[c - 'a'];
        }
        for(int i = 0 ; i < count.length; ++i) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
// If add uppercase letter, int[] count = new int[52];
// ASCII码的话通常为127位，拓展到256位，有范围的都可以通过建立int[]来优化HashMap
// 但是如果是Unicode, 0- 2^31，那么只能用HashMap
// 用int[] 优化HashMap适用于input连续的情况，如果input不连续，那么用HashMap更好。比如court sort中如果数据不连续，有一个特别大的数据count的个数会随着数据的增大而增大，中间会有很多空的count