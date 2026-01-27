import java.util.*;

class Solution {
    public ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        int n1 = arr1.length, n2 = arr2.length;
        
        while (i < n1 && j < n2) {
            // skip duplicates in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            
            // skip duplicates in arr2
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }
}
