class Solution {
    public int mySqrt(int x) {
        // Corner cases
        if (x <= 1) return x;
        int left = 1;
        int right = x/2;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left)/2;
            // times will be outOfEdge so that use divide, but dividor should not be 0
            // The condition is mid <= x/mid && (mid + 1) > x/(mid + 1)
            if (mid <= x/mid && (mid + 1) > x/(mid + 1)) {
                return mid;
            } else if (mid > x/mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}