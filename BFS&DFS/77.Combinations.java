/*
From: stellari
在递归过程中，f(n)中的n次递归调用是f(n-1), f(n-2), f(n-3), ... f(1), f(0)，并不都是f(n-1)。
与加法n + n + n + ... + n (n 个 n) 是 O(n^2) 级别的，而 1 + 2 + 3 + .. + n 也是O(n^2)级别的不同，递归调用是在前一层的基础之上再次进行调用，因此应该是 小于等于 O(2^n). 
如果真的要细扣的话，Subset总共产生2^n个Subset，但是每个Subset的长度是n数量级的，所以Subset的复杂度应该是O(n*2^n) （你可以自行验证一下，所有subset中‍‌‌‌‍‌‍‌‍‌‍‌‌‌‌‌‌‌‌的元素个数总数是n*2^(n-1)）。
这个式子严格来说不能写成O(2^n)。不过为了突出这个式子中的最大头部分2^n，很多人 ( 比如我 ) 还是简单地说这个算法是“指数运行时间”的，并把n略去不写，只是咱们自己还是要清楚那里其实有个n在那里。同理，Combination的复杂度其实也是O(k * C(n, k))。
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        dfs(result, sol, n, 1, k, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> sol, int n, int start, int k, int level) {
        if (level == k) {
            // Deep copy
            List<Integer> temp = new ArrayList<>(sol);
            result.add(temp);
            return;
        }
        
        for (int i = start; i <= n ; ++i) {
            sol.add(i);
            dfs(result, sol, n, i + 1, k, level +1);
            sol.remove(sol.size() - 1);
        }
    }
}