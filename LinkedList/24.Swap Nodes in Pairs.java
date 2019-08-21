// Recursion
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
		return head;
        }
        ListNode newHead = swapPairs(head.next.next);
        ListNode cur = head.next;
        head.next = newHead;
        cur.next = head;
        return cur;
    }
}

// Or
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        return head;
        }
        ListNode newHead = swapPairs(head.next.next);
        head.next.next = head;
        ListNode cur = head.next;
        head.next = newHead;
        return cur;
    }
}

// Iteration, use dummy node
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        while (cur.next!= null && cur.next.next != null) {
            ListNode nex = cur.next.next;
            cur.next.next = nex.next;
            nex.next = cur.next;
            cur.next = nex;
            cur = nex.next;
        }
        
        return dummy.next;

    }
}