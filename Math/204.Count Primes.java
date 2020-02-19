// The method to count every number will be out of memory
// So the initial status is always false, when find a prime number, the number which has this prime will be true.
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] flag = new boolean[n + 1];
        for (int i = 2; i < n; ++i) {
            if (flag[i] == false) {
                ++count;
                flag[i] = true;
                for (int j = 2; j *i <= n; ++j) {
                    flag[i*j] = true;
                }
            }
        }
        return count;
    }
}