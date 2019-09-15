class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
            return -1;
        }
        // word dictionary
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        int num = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String str = q.poll();
                char[] charArray = str.toCharArray();
                // for each word
                for (int i = 0; i < charArray.length; ++i) {
                    // Always keep the original char to make a cache
                    char temp = charArray[i];
                    // do iteration for each character
                    for(char c = 'a' ; c <= 'z'; ++c) {
                        charArray[i] = c;
                        // Change char array to String, String.valueOf(char[]);
                        // String newString = String.valueOf(charArray);
                        String newString = new String(charArray);
                        if (set.contains(newString)) {
                            // Use .equals() to compare
                            if(newString.equals(endWord)) return num + 1;
                            q.offer(newString);
                            // Remove duplication
                            set.remove(newString);
                        }
                    }
                    // return to the original one
                    charArray[i] = temp;
                }
            }
            ++num;
        }
        return 0;
    }
}