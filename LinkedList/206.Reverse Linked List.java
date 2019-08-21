// Iteration
/*
using prev and next to record what head should point to
the end condition of while loop is when cur == null, then prev will be the head
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
    public ListNode reverseList(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
    
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

// Recursion
/*
node1 →  node2 → node3 → node4 → node5 →  node6 →  null
head
null      node1 → node2 → node3 → node4 → node5 → node6 → null
head
null      node2  → node3  → node4  → node5  → node6
head
null      node3  → node4  → node5  → node6
head
null ←  node4  ←  node5  ←  node6
head
null ←  node5  ←  node6
head
node6 → null
                                                          null
                                                           ^
                                                           |
Once reverse, like null ←  node5  ←  node6, now node4 -> node5 <- node6
we need let node4.next.next = node4, node4.next = null
Finally will return the newNode, start from node6                                                     
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
    public ListNode reverseList(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}