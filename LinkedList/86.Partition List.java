/*
1.build two new node to record the small linkedlist and the big linkedlist
2.let the new node to connect to the compared nodes
3.connect small linkedlist and the big linkedlist
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
    public ListNode partition(ListNode head, int x) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(-1);
        ListNode scur = small;
        ListNode big = new ListNode(-1);
        ListNode bcur = big;
        
        while (head != null) {
            if (head.val < x) {
                scur.next = head;
                scur = scur.next;
            } else {
                bcur.next = head;
                bcur = bcur.next;
            }
            head = head.next;
        }
        bcur.next = null;
        scur.next = big.next;
        return small.next;
        
    }
}