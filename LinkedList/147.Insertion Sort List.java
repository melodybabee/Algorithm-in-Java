/*
1.create a new dummy node starting a new linkedlist
2.start from this new linkedlist at every time, iterate the old linkedlist and to compare the new linkedlist with the cur node
3.if find the position larger than the cur, insert the cur to the right place
4.copy the target node to the new linkedlist

need create a new linkedlist, use cur to do the for loop of the old linkedlist than connect to the new one.
*/
// T(n) = O(n^2);
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
        if (head != null && head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode prev = dummy;
        ListNode temp = null;
        while(cur != null) {
            prev = dummy;
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            temp = cur;
            cur = cur.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }
}
