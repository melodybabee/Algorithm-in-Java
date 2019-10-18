class Solution {
    
    private class V {
        private char ch;
        private List<V> neighs;
        private boolean visited;
        private V (char ch) {
            this.ch = ch;
            this.neighs = new ArrayList<V>();
            this.visited = false;
        }
    }
    private int sol = 0;
    public String alienOrder(String[] words) {
        // Corner cases
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        // List of nodes
        List<V> vs = new ArrayList<>();
        // Graph, each index is a graph start from itself
        V[] graph = new V[26];
        String prev = words[0];
        // Compare one by one to build the graph
        for (int i = 1; i < words.length; ++i) {
            String cur = words[i];
            int idx1 = 0;
            int idx2 = 0;
            while (idx1 < prev.length() && idx2 < cur.length() ) {
                char ch1 = prev.charAt(idx1++);
                char ch2 = cur.charAt(idx2++);
                if (graph[ch1 - 'a'] == null) {
                    graph[ch1 - 'a'] = new V(ch1);
                    vs.add(graph[ch1 - 'a']);
                }
                if (graph[ch2 - 'a'] == null) {
                    graph[ch2 - 'a'] = new V(ch2);
                    vs.add(graph[ch2 - 'a']);
                }
                if (ch1 != ch2) {
                    graph[ch1 - 'a'].neighs.add(graph[ch2 - 'a']);
                    break;
                }
            }
            while (idx1 < prev.length()) {
                char ch = prev.charAt(idx1++);
                if (graph[ch - 'a'] == null) {
                    graph[ch - 'a'] = new V(ch);
                    vs.add(graph[ch - 'a']);
                }
            }
            
            while (idx2 < cur.length()) {
                char ch = cur.charAt(idx2++);
                if (graph[ch - 'a'] == null) {
                    graph[ch - 'a'] = new V(ch);
                    vs.add(graph[ch - 'a']);
                }
            }
            prev= cur;
        }
        char[] chars = new char[vs.size()];
        sol = vs.size() - 1;
        // Find through each node, if there is a cycle, return ""
        for (V node : vs) {
            if (hasCycle(node, chars, new HashSet<V>())) {
                return "";
            }
        }
        return new String(chars);
    }
    
    // DFS find cycle. so it will go the end at first
    // Topological sort
    private boolean hasCycle (V node, char[] chars, HashSet<V> set) {
        if (set.contains(node)) {
            return true;
        }
        if (node.visited) {
            return false;
        }
        node.visited = true;
        set.add(node);
        for (V vnode : node.neighs) {
            if (hasCycle(vnode, chars, set)) {
                return true;
            }
        }
        set.remove(node);
        // Node is one of the target
        chars[sol--] = node.ch;
        return false;
    }
}