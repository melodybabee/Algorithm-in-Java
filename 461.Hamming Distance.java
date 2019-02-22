位运算和C++操作相同
class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int count = 0;
        for(int i = 0; i < 32; ++i){
            count += (temp>>i)&1;
        }
        return count;
    }
}