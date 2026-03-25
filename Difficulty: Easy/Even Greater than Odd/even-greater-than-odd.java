import java.util.ArrayList;

class Solution {
    // Method to rearrange the array
    public ArrayList<Integer> rearrangeArray(ArrayList<Integer> arr) {
        
        for (int i = 1; i < arr.size(); i++) {
            
            // Even index (1-based) → i is odd (0-based)
            if (i % 2 == 1) {
                if (arr.get(i) < arr.get(i - 1)) {
                    // swap
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i - 1));
                    arr.set(i - 1, temp);
                }
            } 
            // Odd index (1-based) → i is even (0-based)
            else {
                if (arr.get(i) > arr.get(i - 1)) {
                    // swap
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i - 1));
                    arr.set(i - 1, temp);
                }
            }
        }
        
        return arr;
    }
}