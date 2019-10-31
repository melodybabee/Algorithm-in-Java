// Keep a pair to find the max difference value
class Solution {
    public int maxProfit(int[] prices) {
        // Corner cases
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] - min > res) {
                res = prices[i] - min;
            }
            min = Math.min(prices[i],min);
        }
        return res;
    }
}