/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Corner cases
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger nest: nestedList) {
                queue.offer(nest);
        }
        int res = 0;
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int subsum = 0;
            while(size-- > 0) {
                NestedInteger temp = queue.poll();
                if (temp.isInteger()) {
                    subsum += (temp.getInteger() * level);
                } else {
                    for (NestedInteger n : temp.getList()) {
                        queue.offer(n);
                    }
                }
            }
            res += subsum;
            ++level;
        }
        return res;
    }
}