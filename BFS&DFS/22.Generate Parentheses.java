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
        // whether need duplication or not, should identify this process is in the tree or in the graph
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


// dfs + delta
// T(n) = O(2^n), the constant factor is exponent
// S(n) = O(n), recursion stack is the exponent
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, n, 0, sb);
        return res;
    }
    
    private void dfs(List<String> res, int n, int delta, StringBuilder sb) {
        if (sb.length() == n * 2 && delta == 0) {
            res.add (sb.toString());
            return;
        }
        
        if (sb.length() >= n * 2 || delta < 0) {
            return;
        }
        sb.append('(');
        dfs(res, n, delta + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        dfs(res, n, delta - 1, sb);
        sb.setLength(sb.length() - 1);
    }
}