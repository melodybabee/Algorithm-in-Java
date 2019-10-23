class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Corner cases
        int start = gas.length;
        int end = 0;
        int total = 0;
        // Start is the start postion of the car, the init postion is 0
        while(end < start) {
            if (total < 0) {
                --start;
                total += gas[start] - cost[start];
            } else {
                total += gas[end] - cost[end];
                ++end;
            }
        }
        return total >= 0 ?  (start == gas.length ? 0 : start) : -1;
    }
}