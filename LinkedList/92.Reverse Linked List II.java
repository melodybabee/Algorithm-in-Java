/*
The tricky in this question is reverse the interval if needed.
First we want to find two positions: the postion where before reversing and start reversing.
Then do the reverse of first target elements.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Corner cases
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        for (int i = 0; i < m - 1; ++i) {
            prev = cur;
            cur = cur.next;
        }
        
        if (prev != null) {
            prev.next = reverse(cur, n - m + 1);
        } else {
            return reverse(head, n - m + 1);
        }
        return head;
    }
    
    private ListNode reverse(ListNode head, int num) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        for (int i = 0; i < num; ++i){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = next;
        return prev;
    }
}


