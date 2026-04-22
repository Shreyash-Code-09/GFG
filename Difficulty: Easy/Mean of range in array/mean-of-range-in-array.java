import java.util.*;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // Step 1: Prefix sum array
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 2: Process queries
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            int sum = prefix[r + 1] - prefix[l];
            int length = r - l + 1;
            
            result.add(sum / length); // floor automatically
        }
        
        return result;
    }
}