class LFUCache {
    // a double linkedlist to record the frequency
    class DoubleNode {
        private int count;
        // A key set with the same frequency
        private LinkedHashSet<Integer> keys;
        private DoubleNode prev;
        private DoubleNode next;
        
        private DoubleNode(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private int size;
    private DoubleNode head;
    private HashMap<Integer, DoubleNode> nodeMap;
    private HashMap<Integer, Integer> valueMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleNode(0);
        head.next = null;
        nodeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increase(key);
            return valueMap.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
        } else {
            if (nodeMap.size() < capacity) {
                valueMap.put(key,value);
            } else {
                removeold();
                valueMap.put(key,value);
            }
            addToHead(key);
        } 
        increase(key);
    }
    
    // Increase the frequencey, to the next double linkedlist node
    private void increase(int key) {
        DoubleNode cur = nodeMap.get(key);
        cur.keys.remove(key);
        
        // No more frequencies
        if (cur.next == null) {
            cur.next = new DoubleNode(cur.count + 1);
            cur.next.prev = cur;
            cur.next.keys.add(key);
        } else if (cur.next.count == cur.count + 1) {
            cur.next.keys.add(key);
        // The next node is larger than 1 diff
        } else {
            DoubleNode temp = new DoubleNode(cur.count + 1);
            temp.keys.add(key);
            temp.next = cur.next;
            cur.next = temp;
            temp.next.prev = temp;
            temp.prev = cur;
        }
        
        nodeMap.put(key, cur.next);
        if (cur.keys.size() == 0) remove(cur);
    }
    
    // Remove the less frequency key, the first one of the linkedHashSet
    private void removeold() {
        if (head == null) return;
        int old = 0;
        for (int i : head.keys) {
            old = i;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        nodeMap.remove(old);
        valueMap.remove(old);
    }
    
    // Add a new node with frequency 1
    private void addToHead(int key) {
        if (head == null) {
            head = new DoubleNode(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            DoubleNode newnode = new DoubleNode(0);
            newnode.keys.add(key);
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        } else {
            head.keys.add(key);
        }
        nodeMap.put(key,head);
    }
    
    // If the key has been deleted, the double linkedlist node should be deleted
    private void remove(DoubleNode node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */