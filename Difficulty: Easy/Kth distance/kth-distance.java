import java.util.HashSet;

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            // If element already exists in set → duplicate within k distance
            if (set.contains(arr[i])) {
                return true;
            }
            
            // Add current element
            set.add(arr[i]);
            
            // Maintain window of size k
            if (set.size() > k) {
                set.remove(arr[i - k]);
            }
        }
        
        return false;
    }
}