// find target in an unknown size array
// Should Add - find the edge process should identify whether right value has been over the edge of the reader size, if it is over, read.get(index) will be null.
// The process of finding right edge could be equals to the target.
class Solution {
    public int search(ArrayReader reader, int target) {
        // Corner cases
        if (target >= 10000) {
            return -1;
        }
        int left = 0 ;
        int right = 1;
        int mid = 0;
        // while (reader.get(right) != null && reader.get(right) < target)
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        while (left <= right) {
             mid = left + (right-left)/2;
            
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
}