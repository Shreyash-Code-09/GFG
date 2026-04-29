class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;

        // Step 1: count total 1s
        int k = 0;
        for (int num : arr) {
            if (num == 1) k++;
        }

        // Step 2: if no 1s
        if (k == 0) return -1;

        // Step 3: count 1s in first window
        int currOnes = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 1) currOnes++;
        }

        int maxOnes = currOnes;

        // Step 4: sliding window
        for (int i = k; i < n; i++) {
            if (arr[i] == 1) currOnes++;       // add new element
            if (arr[i - k] == 1) currOnes--;   // remove old element

            maxOnes = Math.max(maxOnes, currOnes);
        }

        // Step 5: result
        return k - maxOnes;
    }
}