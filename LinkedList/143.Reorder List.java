/*
(1) find middle node
(2) cut the original linkedlist to two parts
(3) reverse the second part
(4) connect to them one by one
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = findmid(head);
        ListNode fir = head;
        ListNode sec = mid.next;
        // mid.next should connect to null
        mid.next = null;
        head = merge(fir,reverse(sec));
        return;
    }
    
    private ListNode findmid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            cur.next= l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        // dont forget to connect the last part of l1 if necessary
        cur.next = l1;
        return dummy.next;
    }
}