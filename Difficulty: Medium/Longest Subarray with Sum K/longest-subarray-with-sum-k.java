import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            // Case 1: subarray from 0 to i
            if (sum == k) {
                maxLen = i + 1;
            }
            
            // Case 2: subarray exists
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            
            // Store only first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}