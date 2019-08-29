// when deleting should notice how to deal with head node and the duplicate nodes
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Corner cases
        if (head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;  
    }
}