class Solution {
    int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int[][] nums = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            nums[i][0] = arr[i]; // value
            nums[i][1] = i;      // original index
        }
        
        mergeSort(nums, 0, n - 1, res);
        return res;
    }
    
    void mergeSort(int[][] nums, int left, int right, int[] res) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, res);
        mergeSort(nums, mid + 1, right, res);
        merge(nums, left, mid, right, res);
    }
    
    void merge(int[][] nums, int left, int mid, int right, int[] res) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (nums[j][0] < nums[i][0]) {
                rightCount++;
                temp[k++] = nums[j++];
            } else {
                res[nums[i][1]] += rightCount;
                temp[k++] = nums[i++];
            }
        }
        
        while (i <= mid) {
            res[nums[i][1]] += rightCount;
            temp[k++] = nums[i++];
        }
        
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        
        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = temp[k];
        }
    }
}
