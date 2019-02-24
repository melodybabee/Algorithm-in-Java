暴力解注意：
1.求绝对值是Math.abs()
2.取整数的最大值是Integer.MAX_VALUE;
3.对象形式的，注意比较是否相等比较值的话要用equals形式的，如果是初始类型的就==
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; ++i){
            if(word1.equals(words[i])){
                for(int j = 0; j < words.length; ++j){
                    if(words[j].equals(word2)){
                        res = Math.min(res, Math.abs(j-i));
                    }
                }
            }
        }
        return res;
    }
}

Math.min(),Math.max()
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p = -1;
        int q = -1;
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; ++i){
            if(words[i].equals(word1)){
                p = i;
                if(q != -1){
                    ret = Math.min(ret,i-q);
                }
            }else if(words[i].equals(word2)){
                q = i;
                if(p != -1){
                    ret = Math.min(ret,i-p);
                }
            }
        }
        return ret;
    }
}