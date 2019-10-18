class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        // Corner cases
        if (tickets == null || tickets.size() == 0) return res;
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        // Build grpah
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<String>());
            }
            graph.get(from).offer(to);
        }
        // Search
        dfs(graph, "JFK", res);
        return res;
    }
    
    private void dfs(HashMap<String, PriorityQueue<String>> graph, String cur,  List<String> res) {
        PriorityQueue<String> neis = graph.get(cur);
        while (neis != null && !neis.isEmpty()) {
            String to = neis.poll();
            dfs(graph, to, res);
        }
        // Euler circuit solution, find the end and add from the end
        res.add(0, cur);
    }
}