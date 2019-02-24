注意：
1.建立map,map中仍然套着一个对象的时候Map<String,List<Integer>> map = new HashMap<>();
每当用到这个内部的对象的时候都需要new一个对象出来。
2.List<Integer> list = new ArrayList<Integer>()
用add()方法添加元素
用get()方法获取元素
list的长度为size()

class WordDistance {
    Map<String,List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            if(map.containsKey(word)){
                map.get(word).add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(word,list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < w1.size() && j < w2.size();){
            ret = Math.min(ret, Math.abs(w1.get(i)-w2.get(j)));
            if(w1.get(i) < w2.get(j)){
                ++i;
            }else{
                ++j;
            }
        }
        return ret;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */