/*
Use two pointers to iterate two linkedlist. When finding one of them is null, walk from the another top of them.
if Both of them are null, means they have no intersection. and at this time is also cur1 == cur2.
so while cur1 != cur2, do the iteration and once cur1 == cur2, return cur1 (possibility is interaction point or null)
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Corner cases
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        
        while (cur1 != cur2) {
            if (cur1 == null) {
                cur1 = headB;
            } else {
                cur1 = cur1.next;
            }
            
            if (cur2 == null) {
                cur2 = headA;
            } else {
                cur2 = cur2.next;
            }
            
            
        }
        return cur1;
    }
}