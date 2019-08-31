// sort in the linkedlist
// should create a dummy node to record the new node and use a next point to record the cur.next position.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = cur;
        while (cur != null) {
            prev = dummy;
            while (prev.next != null && prev.next.val < cur.val){
                prev = prev.next;
            }
            next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}