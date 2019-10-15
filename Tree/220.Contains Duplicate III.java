// T(N) = O(N*logN); logN is for the TreeSet to get the range of specific value
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i - k > 0) {
                set.remove(Long.valueOf(nums[i - k - 1]));
            }
            long upper = (long)nums[i] + t;
            long lower = (long)nums[i] - t;
            // The lower(E e) method is used to return the greatest element in this set strictly less than the given element, or null if there is no such element.
            // In case there is situation for equals to the valuer
            Long val = set.lower(upper + 1);
            if (val != null && val >= lower) {
                return true;
            }
            set.add(Long.valueOf(nums[i]));
        }
        return false;
    }
}