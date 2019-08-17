/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// G G G B B, bur isBadVersion() will return true when it is bad
// O(n) = logN
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Corner cases
        if (n <= 0) return -1;
        
        int left = 0;
        int right = n;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right-left)/2;
            
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        
        if (isBadVersion(left)) {
            return left;
        } else {
            return right;
        }
        
    }
}