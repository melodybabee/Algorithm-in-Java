// find the times that N pages have been used.
/*
the citations array means the times that each article has been used.
so if the middle value equals to the right side lenght, then return directly.
else do the comparation.
*/
 // O(logN);
class Solution {
    public int hIndex(int[] citations) {
        // Corner cases
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int left = 0;
        int total = citations.length;
        int right = citations.length-1;
        int mid = 0;
        int result = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (citations[mid] == (total-mid)) {
                return total-mid;
            } else if (citations[mid] < (total-mid)) {
                left = mid +1; 
            } else if (citations[mid] > (total-mid)) {
                right = mid - 1;
            }
        }
        return total - left;
        
    }
}