import java.util.*;

class Solution {
    
    static class Pair {
        int val, idx;
        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }
    
    ArrayList<Integer> findSurpasser(int[] arr) {
        int n = arr.length;
        
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }
        
        int[] count = new int[n];
        
        mergeSort(pairs, 0, n - 1, count);
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(count[i]);
        }
        
        return result;
    }
    
    void mergeSort(Pair[] arr, int left, int right, int[] count) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        
        mergeSort(arr, left, mid, count);
        mergeSort(arr, mid + 1, right, count);
        
        merge(arr, left, mid, right, count);
    }
    
    void merge(Pair[] arr, int left, int mid, int right, int[] count) {
        List<Pair> temp = new ArrayList<>();
        
        int i = left, j = mid + 1;
        
        while (i <= mid && j <= right) {
            if (arr[i].val < arr[j].val) {
                // all remaining elements on right are greater
                count[arr[i].idx] += (right - j + 1);
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
            }
        }
        
        while (i <= mid) temp.add(arr[i++]);
        while (j <= right) temp.add(arr[j++]);
        
        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}