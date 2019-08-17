注意：
        1.Java中所有的结点都是dummy,cur等，不存在指针形式或者取值，都以对象形式出现，获取构造器里面的值用.来取
        2.while()中包括的是boolean类型的条件，因此如果判断不为0的话那么需要写成！=null

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int temp = 0;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + temp) % 10);
            temp = (l1.val + l2.val + temp) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while (l1 != null) {
            cur.next = new ListNode((l1.val + temp) % 10);
            temp = (l1.val + temp) / 10;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = new ListNode((l2.val + temp) % 10);
            temp = (l2.val + temp) / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        if (temp > 0) cur.next = new ListNode(temp);
        return dummy.next;
    }
}