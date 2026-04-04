import java.util.*;

class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        result.add("");  // FIX
        
        for (int i = 0; i < n; i++) {
            int size = result.size();
            
            // Reverse and add
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j));
            }
            
            // Add 0 prefix
            for (int j = 0; j < size; j++) {
                result.set(j, "0" + result.get(j));
            }
            
            // Add 1 prefix
            for (int j = size; j < result.size(); j++) {
                result.set(j, "1" + result.get(j));
            }
        }
        
        return result;
    }
}