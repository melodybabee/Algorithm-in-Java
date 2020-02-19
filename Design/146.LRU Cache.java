class LRUCache {
    private class DoubleNode {
        int val;
        int key;
        DoubleNode prev;
        DoubleNode next;
        public DoubleNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private int size;
    private DoubleNode head;
    private DoubleNode tail;
    private HashMap<Integer, DoubleNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleNode(0,0);
        tail = new DoubleNode(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            DoubleNode temp = map.get(key);
            moveToFront(temp);
            return temp.val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleNode temp = map.get(key);
            temp.val = value;
            moveToFront(temp);
        } else {
            DoubleNode newnode = new DoubleNode(key, value);
            map.put(key,newnode);
            if (size < capacity) {
                ++size;
            } else {
                DoubleNode newtail = tail.prev;
                newtail.prev.next = tail;
                tail.prev = newtail.prev;
                map.remove(newtail.key);
            }
            moveToFront(newnode);
        }
    }
    private void moveToFront(DoubleNode node) {
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */