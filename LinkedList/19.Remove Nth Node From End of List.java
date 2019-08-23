// fast pointer and slow pointer to find the target position
// let fast pointer walks n at first
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Corner case
        if (head == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        // if the first one is the one that should be deleted
        if (fast == null) {
            return head.next;
        }
        
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
        
    }
}