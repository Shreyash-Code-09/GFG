import java.util.HashMap;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int count = 0;
        
        // sum 0 occurs once initially
        map.put(0, 1);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            // check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // store current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
