java中的swap函数需要自定义，否则需要设置temp变量
class Solution {
    public int[] sortArrayByParity(int[] A) {
        for(int i = 0, j = 0; j < A.length; ++j){
            if(A[j] % 2 == 0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                ++i;
            }
        }
        return A;
    }
}