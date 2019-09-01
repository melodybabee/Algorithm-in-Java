// Solution 1: min heap, straight forward
// T(n) = O(n^2) + O(NlogN) for inserting in heap
// S(n) = O(N) for heap, heap received as array and in logic it is complete binary tree
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return -1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                pq.offer(matrix[i][j]);
            }
        }
        
        while(k > 1) {
            pq.poll();
            --k;
        }
        
        return pq.poll();
    }
}

// Solution 2: heap + BFS
/*
the min heap is k, find from the (0,0), push its neighboor every time for right and down, --k at the same time
when k == 1, the top of heap is the target
we should use a visited matrix to remember whether this position has been visited
T(n) = klogK, k for insert and K is the capacity for heap
S(n) = O(K) for heap + O(M*N)， if use hashset for visited, it can be O(K)/O(M+N-1);
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return -1;// TO be changed
        }
        // Comparator<int[]>(){} has claimed a new anonymous class to override compare function, Comparator itself is an interface
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
        	// Override should be caps up, not override
            @Override
            // access modifier is public, and the method name is compare
            public int compare(int[] l1, int[] l2) {
                return matrix[l1[0]][l1[1]] - matrix[l2[0]][l2[1]];
            }
        });
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        pq.offer(new int[]{0,0});
        while (k > 1) {
            int[] temp = pq.poll();
            int row = temp[0];
            int col = temp[1];
            
            if(isValid(row + 1,col,matrix,visited)) {
                pq.offer(new int[]{row + 1, col});
                visited[row + 1][col] = true;
            }
            
            if(isValid(row,col + 1,matrix,visited)) {
                pq.offer(new int[]{row, col + 1});
                visited[row][col + 1] = true;
            }
            --k;
        }
        int[] temp = pq.poll();
        int row = temp[0];
        int col = temp[1];
        return matrix[row][col];
    }
    
    private boolean isValid(int row, int col,int[][] matrix, boolean[][] visited) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && !visited[row][col]) {
            return true;
        }
        
        return false;
    }
}