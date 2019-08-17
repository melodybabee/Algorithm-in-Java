/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

// extends method from other class, it can be called directly in this class
// O(logN),mainly log2^N O(1)
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // Corner cases
        if (n < 1) return -1;
        
        int left = 0;
        int right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}