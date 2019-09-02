//DFS 1
/*
level: when equals to the 2*n
col: left side and right side, so it is two dfs part
answer: when left and right don't meet the requirements, return, if sum == 2*n, return answer
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        // Corner cases
        if (n <= 0) return result;
        // StringBuilder is a class
        StringBuilder st = new StringBuilder();
        dfs(result, n, 0, 0, st);
        return result;
    }
    
    private void dfs(List<String> result, int total, int left, int right, StringBuilder st) {
        if (left > total || right > left) {
            return;
        }
        if (left + right == 2*total) {
            // toString() is a method
             result.add(st.toString());
        }
        st.append('(');
        dfs(result, total, left + 1, right, st);
        // StringBuilder is kind of String, so it has length() method. deleteCharAt() is also a method
        st.deleteCharAt(st.length() - 1);
        st.append(')');
        dfs(result, total, left, right + 1, st);
        st.deleteCharAt(st.length() - 1);
    }
}

// DFS with pruning
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        // Corner cases
        if (n <= 0) return result;
        StringBuilder st = new StringBuilder();
        dfs(result, n, 0, 0, st);
        return result;
    }
    
    private void dfs(List<String> result, int total, int left, int right, StringBuilder st) {
        // reach the leaf
        if (left + right == 2*total) {
            result.add(st.toString());
        }
        if (left < total) {
            st.append('(');
            dfs(result, total, left + 1, right, st);
            st.deleteCharAt(st.length() - 1);
        }
        
        if (right < left) {
            st.append(')');
            dfs(result, total, left, right + 1, st);
            st.deleteCharAt(st.length() - 1);
        }
    }
}