import java.util.*;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        
        HashSet<Long> set = new HashSet<>();
        
        for(int num : arr) {
            
            // Handle zero case
            if(num == 0) {
                if(target == 0 && !set.isEmpty())
                    return true;
            } 
            else {
                if(target % num == 0) {
                    long need = target / num;
                    
                    if(set.contains(need))
                        return true;
                }
            }
            
            set.add((long)num);
        }
        
        return false;
    }
}