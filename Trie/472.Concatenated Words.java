class Solution {
    private class TrieNode {
        private boolean isWord;
        private TrieNode[] neighs;
        private TrieNode() {
            neighs = new TrieNode[26];
        } 
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        // Corner cases
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (String str: words) {
            addWord(str, root);
        }
        
        for (String str: words) {
            if(isWord(str, root, 0, 0)) {
                res.add(str);
            }
        }
        return res;
    }
    
    private void addWord(String str, TrieNode root) {
        TrieNode cur = root;
        char[] chars = str.toCharArray();
        for (char ch: chars) {
            if (cur.neighs[ch - 'a'] == null) {
                cur.neighs[ch - 'a'] = new TrieNode();
            }
            cur = cur.neighs[ch - 'a'];
        }
        cur.isWord = true;
    }
    
    private boolean isWord(String str, TrieNode root, int count, int index) {
        TrieNode cur = root;
        char[] chars = str.toCharArray();
        for (int i = index; i < str.length(); ++i) {
            if (cur.neighs[chars[i] - 'a'] == null) {
                return false;
            }
            if (cur.neighs[chars[i] - 'a'].isWord) {
                if (i == chars.length - 1) {
                    return count > 0;
                }
                if (isWord(str,root, count + 1, i + 1)) {
                    return true;
                }
            }
            cur = cur.neighs[chars[i] - 'a'];
        }
        return false;
    }
    
}