class Solution {
    public int fib(int N) {
       if(N == 0) return 0;
       if(N == 1) return 1;
        return fib(N-1) + fib(N-2);
    }
}
注意：
必须要有if (N <= 1) return N;不然res[1]会出界，使用int[]一定要注意边界问题
class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        int[] res= new int[N+1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= N; ++i){
            res[i] = res[i-1] + res[i-2];
        }
        return res[N];
    }
}