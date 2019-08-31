// Notice the requirement is to find the kth largest element in the sorted order, not the kth distinct element.
// Solution 1: Arrays.sort(), this method is from import java.util.Arrays;
// O(n) = O(NlogN);
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}


// Solution 2: quick sort
// O(n) find the targer for one time, because we could ignore the half part, so the average is O(n), and the worst is - O(n^2);
/*
The points that need noted:
1.in quick sort, should be add a range of sort process, so that add a new helper function to do so
2.set the last element to be the pivot, when do for loop, the index should less than the end, and start from the start
3.make a index to be the position of swap with the end element. so if it is less than the end, index++. The iteration of i should swap with index if find a value less than the pivot.
4.compare the position with k, equals return directly, else quicksort again
***5.because it is starting from the start to the end, so k could be the same.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Corner cases
        if (nums == null || nums.length == 0){
            return -1;
        }
        return quickSort(nums, 0, nums.length-1, nums.length-k);
    }
    
    private int quickSort(int[] nums, int start, int end, int k){
        int index = start;
        int pivot = nums[end];
        
        for(int i = start; i < end; ++i) {
            if(nums[i] <= pivot){
                swap(index, i, nums);
                ++index;
            }
        }
        swap(index, end, nums);
        if (index == k) return nums[k];
        else if (index < k) return quickSort(nums, index + 1, end, k);
        else return quickSort(nums, 0, index-1, k);
    }
    
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// Solution 3 using min heap
// T(n) = O((n-k)logK + K) S(n) = O(K);
/*
1.PriorityQueue is a class and it implements Queue interface
2. min heap is pushing element one by one, when the number is larger than the k, then polling out. The elements in the heap is always top k largert numbers.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

// Solution 4 using max heap
// T(n) = O(klogN + N) S(n) = O(N);
/*
1.The comparator is in the () method, (n1, n2) -> (n1-n2) is min heap, and (n1, n2) -> (n2-n1) is max heap;
2.offer all element in the pq, poll the kth element
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        Queue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> (n2-n1));
        
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(nums[i]);
        }
        int start = 1;
        while (start < k) {
            pq.poll();
            ++start;
        }
         return pq.poll();
    }
}

// Solution 5: treemap
/*
1.the key and value in the map is object, map is an interface
2.boolean:map.containsKey(); boolean:map.containsValue();
map.get(key);map.put(key,value);
map.keySet(); map.entrySet();
3.Map.Entry<K,V> is an interface, entry.getKey(),entry.getValue();
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Corner cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                map.put(num, ++count);
            } else {
                map.put(num,1);
            }
        }
        
        int count = 0;
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            count += e.getValue();
            if (count > nums.length - k) {
                return e.getKey();
            }
        }
        return -1;
    }
}