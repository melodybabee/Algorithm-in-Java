注意：
1.在java中一定要注意区分对象和原始变量，对象都是调用方法，比如String，它的长度是length(),而一个二位数组int[][]的长度就可以为size()
2.同时在String中求字符要用String.charAr()方法来表示
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); ++i){
            for(int j = 0; i-j >= 0 && i+j < s.length() && s.charAt(i-j)==s.charAt(i+j); ++j) ++count;
            for(int j = 0; i-1-j >= 0 && i+j < s.length() && s.charAt(i-1-j) == s.charAt(i+j);++j) ++count;
        }
        return count;
    }
}