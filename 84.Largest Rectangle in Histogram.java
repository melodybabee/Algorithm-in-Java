注意：
1.要用Math.min()和Math.max()
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for(int i = 0 ; i < heights.length; ++i){
            if(i+1 < heights.length && heights[i] < heights[i+1]) continue;
                int temp = heights[i];
                for(int j = i; j >= 0; --j){
                    temp = Math.min(temp,heights[j]);
                    result = Math.max(result, temp*(i-j+1));
                }
        }
        return result;
    }
}
注意：
1.Stack中的类型也必须是对象的形式，Stack<Integer> st = new Stack<Integer>();
2.int[]声明后是不可以改变大小的，所以思路有所不同，需要在stack中添加-1，再最后用一个while循环进行判断
3.peek()是返回栈顶元素，pop()是返回栈顶元素的同时弹出栈顶元素
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int ret = 0;
        for(int i = 0; i< heights.length; ++i){
            while(st.peek() != -1 && heights[st.peek()] >= heights[i]){
                int temp = st.pop();
                ret = Math.max(ret,heights[temp] * (i-st.peek()-1));
            }
            st.push(i);
        }
        
        while(st.peek() != -1){
            int temp= st.pop();
            ret = Math.max(ret,heights[temp] * (heights.length-st.peek()-1));
        }
        return ret;
    }
}