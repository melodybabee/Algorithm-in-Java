注意：
        1.在java中一定要注意区分对象和原始变量，对象都是调用方法，比如String，它的长度是length(),而一个二位数组int[][]的长度就可以为length
        java中的length属性是针对数组说的,比如说你声明了一个数组,想知道这个数组的长度则用到了length这个属性.
        java中的length()方法是针对字符串String说的,如果想看这个字符串的长度则用到length()这个方法.
        java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看
        2.同时在String中求字符要用String.charAr()方法来表示

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); ++j) ++count;
            for (int j = 0; i - 1 - j >= 0 && i + j < s.length() && s.charAt(i - 1 - j) == s.charAt(i + j); ++j)
                ++count;
        }
        return count;
    }
}