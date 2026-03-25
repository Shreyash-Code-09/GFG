class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        
        // If kth missing is beyond last element
        if (k > arr[n - 1] - n) {
            return arr[n - 1] + (k - (arr[n - 1] - n));
        }
        
        int low = 0, high = n - 1;
        
        // Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Missing numbers till index mid
            int missing = arr[mid] - (mid + 1);
            
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // Answer
        return low + k;
    }
}