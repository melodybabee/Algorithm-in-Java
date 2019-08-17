声明一个新的数组int[]result=new int[N+1];括号里表示大小即可。

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] result = new int[N + 1];
        for (int[] t : trust) {
            ++result[t[1]];
            --result[t[0]];
        }
        for (int i = 1; i <= N; ++i) {
            if (result[i] == N - 1) return i;
        }
        return -1;
    }
}