// Solution 1: two pointers 
class Solution {
    public void reverseString(char[] s) {
        // Corner cases
        if (s == null || s.length == 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            swap(i,j,s);
            ++i;
            --j;
        }
        return;
    }
    
    private void swap(int i, int j, char[] s) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

// Solution 2, swap and recursion
class Solution {
    public void reverseString(char[] s) {
        // Corner cases
        if (s == null || s.length == 0) {
            return;
        }
        dfs(s, 0, s.length - 1);
        return;
    }
    
    private void dfs(char[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(a, start, end);
        dfs(a, ++start, --end);
    }
    
    private void swap(char[] a, int start, int end) {
        char c = a[start];
        a[start] = a[end];
        a[end] = c;
    }
}

// Solution 3, recursion and swap
class Solution {
    public void reverseString(char[] s) {
        // Corner cases
        if (s == null || s.length == 0) {
            return;
        }
        dfs(s, 0, s.length - 1);
        return;
    }
    
    private void dfs(char[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        // Notice that this must be start + 1 and end -1, recursion will record the original value
        // While the start++, end-- will not change the recursion value, and ++start, --end will change the backtracking value.
        dfs(a, start + 1, end -1);
        swap(a, start, end);
        
    }
    
    private void swap(char[] a, int start, int end) {
        char c = a[start];
        a[start] = a[end];
        a[end] = c;
    }
}