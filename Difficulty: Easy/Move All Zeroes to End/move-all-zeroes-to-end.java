class Solution {
    void pushZerosToEnd(int[] arr) {
        int j = -1;

        // find first zero
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // if no zero found, array is already correct
        if (j == -1) return;

        // swap non-zero elements
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
