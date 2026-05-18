class Solution {
    public int peakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Peak lies on right side
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } 
            // Peak lies on left side or mid itself
            else {
                high = mid;
            }
        }

        return low;
    }
}