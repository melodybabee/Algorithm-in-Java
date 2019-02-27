isEmpty() 或者(list.size() == 0)用于判断List内容是否为空，即表里一个元素也没有， 但是使用isEmpty()和size()的前提是，list是一个空集合，而不是null，所以为了避免异常，建议在使用或赋值list集合之前，做一次空集合创建处理，进行内存空间分配
list.isEmpty()和list.size()==0 没有区别， isEmpty()判断有没有元素，而size()返回有几个元素，如果判断一个集合有无元素，建议用isEmpty()方法. 这清晰,简明
list等于null，可理解为没有对list集合分配内存空间，实际上压根就不存在。
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}