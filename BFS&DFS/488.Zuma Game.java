class Solution {
    private int min;
    public int findMinStep(String board, String hand) {
        // Corner cases
        if (board == null || board.length() == 0 || hand == null || hand.length() == 0) {
            return -1;
        }
        min = hand.length() + 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            } 
            map.put(c, map.get(c) + 1);
        }
        dfs(board, map, 0);
        return (min == hand.length() + 1) ? -1 : min;
    }
    
    private void dfs(String board, HashMap<Character, Integer> map, int count) {
        int len = board.length();
        if (len == 0) {
            min = Math.min(count, min);
            return;
        }
        if (map.isEmpty()) {
            System.out.println("empty");
            return;
        }
        for (int i = 0; i < len; ++i) {
            char ch = board.charAt(i);
            Integer num = map.get(ch);
            if (num == null) {
                continue;
            }
            if (i + 1 < len && board.charAt(i+1) == ch) {
                // Add one ball
                int newCount = num - 1;
                map.remove(ch);
                if (newCount > 0) {
                    map.put(ch, newCount);
                }
                dfs(generate(board, i - 1, i + 2), map, count + 1);
                map.put(ch,num);
            } else if (num >= 2) {
                // Add two balls
                map.remove(ch);
                if (num > 2) {
                    map.put(ch, num - 2);
                }
                dfs(generate(board, i - 1, i + 1), map, count + 2);
                map.put(ch, num);
            }
        }
    }
    
    private String generate(String board, int left, int right) {
        int len = board.length();
        while (left >= 0 && right < len) {
            int count = 0;
            char c = board.charAt(left);
            // Need record the left as l and the right as r, so that if count < 3, it will add thr original string
            int l = left;
            while (l >= 0 && board.charAt(l) == c) {
                ++count;
                --l;
            }
            int r = right;
            while (r < len && board.charAt(r) == c) {
                ++count;
                ++r;
            }
            if (count >= 3) {
                left = l;
                right = r;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= left; ++i) {
            sb.append(board.charAt(i));
        }
        for (int i = right; i < len; ++i) {
            sb.append(board.charAt(i));
        }
        return sb.toString();
    }
}