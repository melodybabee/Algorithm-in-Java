
class Solution {
   
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2) {
                return c1.sum - c2.sum;
            }
        });
        // Remove duplication
        HashSet<Cell> set = new HashSet<>();
        Cell c = new Cell(nums1[0] + nums2[0], 0, 0);
        pq.offer(c);
        set.add(c);
        while(k-- > 0) {
            if (pq.isEmpty()) break;
            Cell temp = pq.poll();
            int tempi = nums1[temp.i];
            int tempj = nums2[temp.j];
            List<Integer> sol = new ArrayList<>();
            sol.add(tempi);
            sol.add(tempj);
            res.add(sol);
            if (temp.i + 1 < nums1.length) {
                Cell newc = new Cell(nums1[temp.i + 1] + nums2[temp.j], temp.i + 1, temp.j);
                if (!set.contains(newc)) {
                    pq.offer(newc);
                    set.add(newc);
                }
            }
            if (temp.j + 1 < nums2.length) {
                Cell newc = new Cell(nums1[temp.i] + nums2[temp.j + 1], temp.i, temp.j + 1);
                 if (!set.contains(newc)) {
                    pq.offer(newc);
                    set.add(newc);
                }
            }
        }
        return res;
    }
    
    // This class could be in the class Solution or a totally new class
    private class Cell {
        public int sum;
        public int i;
        public int j;
        private Cell (int sum, int i, int j){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
        
        // Use HashSet to remove duplication so that should override hashCode and equals at the same time
        @Override
        public int hashCode() {
            // 31 is a prime number which is not too big
            return this.i*31 + this.j;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Cell) {
                Cell c = (Cell) o;
                return this.i == c.i && this.j == c.j;
            } else {
                return false;
            }
        }
 }
}