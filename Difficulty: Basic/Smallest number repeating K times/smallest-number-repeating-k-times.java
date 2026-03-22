import java.util.*;

class Solution {
    public int findDuplicate(int[] arr, int k) {
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        int count = 1;
        boolean found = false;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count == k) {
                    min = Math.min(min, arr[i - 1]);
                    found = true;
                }
                count = 1;
            }
        }
        
        // Check last element group
        if (count == k) {
            min = Math.min(min, arr[arr.length - 1]);
            found = true;
        }
        
        return found ? min : -1;
    }
}