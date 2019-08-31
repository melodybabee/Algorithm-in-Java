// Use recursion method but the time complecity is too high, so optimize it to dp solution
// class Solution {
//     public int climbStairs(int n) {
//         // base case
//         if (n == 1) return 1;
//         if (n == 2) return 2;
        
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }

// DP solution，T(n) = O(n);
class Solution {
    public int climbStairs(int n) {
        // base case
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}