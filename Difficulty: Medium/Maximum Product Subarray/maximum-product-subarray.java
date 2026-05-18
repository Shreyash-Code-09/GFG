class Solution {
    int maxProduct(int[] arr) {
        
        int maxProd = arr[0];
        int minProd = arr[0];
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // Swap when negative number comes
            if (arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}