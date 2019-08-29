// Because the head node will not be deleted, so that no need the dummy node, do while loop from the head.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            prev = cur;
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            prev.next = cur.next;
            cur = cur.next;
        }
        
        return head;
    }
}