// Find the longest prefix
// The range will between the start and the end so that identify start edge and the end eage is ok
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            // record how many digits will move
            ++res;
        }
        return m << res;
    }
}