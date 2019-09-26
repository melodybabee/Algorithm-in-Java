/*
BFS to build graph and use DFS to find all paths.
*/
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        // Corner cases
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        // Build graph using BFS
        Queue<String> q = new LinkedList<>();
        // Build graph, in opposite directions
        HashMap<String, List<String>> map = new HashMap<>();
        q.offer(beginWord);
        // to record whether reaching to the target
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            // remove duplication, when the currently level finished
            HashSet<String> visited = new HashSet<>();
            while(size-- > 0) {
                String str = q.poll();
                // find in the dictionary
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char temp = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == temp) continue;
                        chars[i] = c;
                        String sol = String.valueOf(chars);
                        if (set.contains(sol)) {
                            if (sol.equals(endWord)) flag = true;
                            
                            // one to one
                            if (!visited.contains(sol)) {
                                List<String> list = new ArrayList<String>();
                                list.add(str);
                                map.put(sol, list);
                                // Only when sol is a new String, push it to then queue, if it has existed, don't push into the queue
                                q.offer(sol);
                                visited.add(sol);
                            } else {
                                // one to more
                                map.get(sol).add(str);
                            }
                        }
                        
                    }
                    chars[i] = temp;
                }
            }
            
            // remove this level's string to avoid the cycle in the same level, this can not be the shortest path
            set.removeAll(visited);
            
            if (flag) {
                // Find path using DFS
                List<String> res = new ArrayList<>();
                res.add(endWord);
                dfs(result, res, beginWord, map, endWord);
                return result;
                
            }
        }
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> res, String start, HashMap<String, List<String>> map, String word) {
        // remember it is equals() !
        if (word.equals(start)) {
            result.add(new ArrayList<String>(res));
            return;
        }
        List<String> str = map.get(word);
        for (int i = 0; i < str.size(); ++i) {
            res.add(0,str.get(i));
            dfs(result, res, start, map, str.get(i));
            res.remove(0);
        }
        
    }
}

// Improve
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashSet<String> words = new HashSet<>();
        for (String str: wordList) {
            words.add(str);
        }
        HashMap<String, List<String>> path = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.offer(beginWord);
        
        // Build graph
        findPath(q, path, endWord, words, flag);
        
        // DFS
        // Need identify whether this graph has formed or not
        if (!path.containsKey(endWord)) return result;
        List<String> sol = new ArrayList<>();
        sol.add(endWord);
        dfs(result, path, beginWord, endWord, sol);
        return result;
    }
    
    private void dfs(List<List<String>> result, HashMap<String, List<String>> path, String beginWord, String endWord, List<String> sol) {
        if (endWord.equals(beginWord)) {
            result.add(new ArrayList<>(sol));
            return;
        }
        
        List<String> words = path.get(endWord);
        for (String word: words) {
            sol.add(0, word);
            dfs(result, path, beginWord, word, sol);
            sol.remove(0);
        }
    }
    
    private void findPath(Queue<String> q, HashMap<String, List<String>> path, String endWord, HashSet<String> words, boolean flag) {
        while (!q.isEmpty()) {
            int size = q.size();
            HashSet<String> visited = new HashSet<>();
            while(size-- > 0) {
                String str = q.poll();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char ch = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String newstring = String.valueOf(chars);
                        if (words.contains(newstring)) {
                            if (newstring.equals(endWord)) {
                                flag = true;
                            }
                            
                            if (!path.containsKey(newstring)) {
                                List<String> list = new ArrayList<>();
                                list.add(str);
                                path.put(newstring, list);
                                q.offer(newstring);
                                visited.add(newstring);
                            } else {
                                path.get(newstring).add(str);
                            }
                        }
                    }
                    chars[i] = ch;
                }
            }
            words.removeAll(visited);
            if (flag) return;
        }
        return;
    }
}