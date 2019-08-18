/* First find the edge of target, left < target, right >= target
Then extend this range to two sides, notice left >= 0 && right < arr.length
*/

// O(logN) + O(k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        // Corner cases
        if (arr == null || arr.length == 0) {
            return result;
        }
    
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        
        
        while (left + 1 < right) {
            mid = left + (right-left)/2;
        
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
           
        }
        
        while (result.size() < k && right < arr.length && left >= 0 ) {
            if (Math.abs(arr[right]-x) < Math.abs(arr[left]-x)) {
                result.add(arr[right]);
                ++right;
            } else if (Math.abs(arr[right]-x) >= Math.abs(arr[left]-x)) {
                result.add(0, arr[left]);
                --left;
            }
        }
        
        while (result.size() < k) {
            if (right >= arr.length) {
                result.add(0, arr[left]);
                --left;
            } else {
                result.add(arr[right]);
                ++right;
            }   
        }
        return result;

    }

}