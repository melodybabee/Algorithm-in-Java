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