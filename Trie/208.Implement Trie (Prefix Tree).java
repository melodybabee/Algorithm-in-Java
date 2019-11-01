class TrieNode {
    /*
    For a TrieNode, it has the value of char, a boolean flag and a TrieNode[] as children
    */
    public char c;
    public boolean isWord;
    public TrieNode[] children;
    
    // root
    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
    
    public TrieNode(char c) {
        this.c = c;
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}
class Trie {
    /*
    In trie, it has a root
    */
    private TrieNode root;
   
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode(word.charAt(i));
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */