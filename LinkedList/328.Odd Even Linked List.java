/*
seperate a linkedlist to two linkedlist, one odd and one even
1.should record the even node in order to connect to a new node, and the odd node is the same as head one, so no need to claim a new one.
2.the while loop condition is when even and even.next existed. If not, the even has reached the end.
3.connect the end of odd to the new node
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
    public ListNode oddEvenList(ListNode head) {
        // Corner cases
        if (head == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode newNode = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = newNode;
        return head;
    }
}