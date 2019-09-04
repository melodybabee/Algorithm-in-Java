// Solution1: brute force merge one by one
// T(n) = O(M * N);
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Corner cases
        if (lists == null || lists.length == 0 ){
            return null;
        }
        ListNode slow = lists[0];
        for (int i = 1; i < lists.length; ++i) {
            ListNode temp = merge(slow, lists[i]);
            slow = temp;
        }
        return slow;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        
        ListNode cur = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return head;
    }
}

// Solution 2 PriorityQueue
// T(n) = O(Nlogk), k is the number of the linkedlist, and n is the length of each linkedlist
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Corner cases
        if (lists == null || lists.length == 0) return null;
        // Comparator is a class, so need to be capitalized.
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        // need offer all linkedlist
        for(ListNode l : lists) {
        	// The most important, if l is null, it doesn't have the val property.
            if(l != null) pq.offer(l);
        }
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            cur.next = temp;
            temp = temp.next;
            cur = cur.next;
            if (temp != null) {
                pq.offer(temp);
            }
        }
        return head.next;
    }
}