/*
Use the merge sort in arraylist method in linkedlist.
how to divide?
1.splite linkedlist in the middle, do the recursion if finish once.
2.the edge case is when head == null || head.next == null;

Merge:
1. After spliting, merge these two nodes.
*/
// divide O(NlogN) + mergeO(NlogN) = O(NlogN)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(next);
        return merge(node1,node2);
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = null;
        ListNode cur = head;
        if (node1.val <= node2.val) {
            cur = node1;
            node1 = node1.next;
        } else {
            cur = node2;
            node2 = node2.next;
        }
        head = cur;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) cur.next = node1;
        if (node2 != null) cur.next = node2;
        return head;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}