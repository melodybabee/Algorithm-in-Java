/*
1. reverse this linkedlist to do adding one operation
2. while loop make the add 1, should notice whether cur.next is null and when to add a new ListNode(1)
3. reverse the linkedlist again
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
    public ListNode plusOne(ListNode head) {
        //Corner case
        if (head == null) {
            return new ListNode(1);
        }
        
        ListNode newHead = reverse(head);
        ListNode cur = newHead;
        if(cur.val != 9) {
            cur.val += 1;
            return reverse(newHead);
        }
    
        while(cur.next != null && cur.val == 9) {
            cur.val = 0;
            cur = cur.next;
        }
    
        if (cur.next == null && cur.val == 9) {
            cur.val = 0;
           cur.next = new ListNode(1);
        } else {
            cur.val += 1;
        }
        
        return reverse(newHead);
    }
    
    private ListNode reverse(ListNode head){
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}