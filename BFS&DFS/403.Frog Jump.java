// DFS with pruninh
class Solution {
    public boolean canCross(int[] stones) {
        // Corner cases
        if (stones == null || stones.length == 0) {
            return false;
        }
        // For every position, create a new hashmap to record its k is true or false
        HashMap<Integer, Boolean>[] mem = new HashMap[stones.length];
        /* which one is wrong
        HashMap map = mem[i];
        if (map == null) {
			map = new HashMap<>();
        }
        In this way, the new map will not attached to the mem[i]
        */
        for(int i = 0; i < mem.length; ++i) {
            mem[i] = new HashMap<Integer, Boolean>();
        }
        return dfs(stones, 0, 0, mem);
    }
    
    private boolean dfs(int[] stones, int k, int index, HashMap<Integer, Boolean>[] mem) {
        HashMap<Integer, Boolean> map = mem[index];
        if (map.containsKey(k)) {
            return map.get(k);
        }
        if (index == stones.length - 1) {
            return true;
        }
        for (int i = index + 1; i < stones.length; ++i) {
            int dist = stones[i] - stones[index];
            if (dist < k - 1) {
                continue;
            } else if (dist > k + 1) {
                break;
            } else {
                if (dfs(stones, dist, i, mem)) {
                    map.put(k, true);
                    return true;
                }
            }
        }
        map.put(k, false);
        return false;
    }
}