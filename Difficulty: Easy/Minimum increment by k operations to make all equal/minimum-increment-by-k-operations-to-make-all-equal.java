class Solution {
    static int minOps(int arr[], int k) {
        int max = Integer.MIN_VALUE;
        
        // Step 1: find max
        for (int num : arr) {
            max = Math.max(max, num);
        }
        
        int ops = 0;
        
        // Step 2: calculate operations
        for (int num : arr) {
            if ((max - num) % k != 0) {
                return -1;
            }
            ops += (max - num) / k;
        }
        
        return ops;
    }
}