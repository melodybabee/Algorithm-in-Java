// DP, O(N^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        // The default value is 1
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// Greedy, O(NlogN)
/*[10,9,2,5,3,7,101,18]
10 101
9 101
2 5 7 101
  3 7 101
  7 18
  101
  18
5 7 101
3 7 101
7 101
101
18
build a binary tree to find the right position
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int n : nums) {
            if (res.isEmpty()) {
                res.add(n);
            } else if (res.get(res.size() - 1) < n) {
                res.add(n);
            } else {
                int index = replaceIndex(res, n);
                res.set(index, n);
            }
        }
        return res.size();
    }
    
    // Find the position to insert
    private int replaceIndex(List<Integer>res, int num) {
        int left = 0;
        int right = res.size() -1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (res.get(mid) == num) {
                return mid;
            } else if (res.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}