/*
when the length is equals to K, the linkedlist should be reversed.
let cur record the last node of current linkedlist starting with head. cur.next = null in order to make reverse
let cur.next part linkedlist into new recursion
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Corner cases
        if (head == null) return head;
        
        // Base cases
        ListNode cur = head;
        for (int i = 0; i < k-1; ++i) {
            cur = cur.next;
            if (cur == null) {
                return head;
            }
        }
        ListNode newNode = reverseKGroup(cur.next, k);
        cur.next = null;
        ListNode subList = reverseLinkedlist(head);
        head.next = newNode;
        return subList;
    }
    
    private ListNode reverseLinkedlist(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseLinkedlist(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}