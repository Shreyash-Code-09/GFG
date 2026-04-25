import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        
        for (int num : arr) {
            boolean added = false;
            
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                
                // Check opposite signs
                if ((top > 0 && num < 0) || (top < 0 && num > 0)) {
                    
                    // Case 1: equal absolute values → remove both
                    if (Math.abs(top) == Math.abs(num)) {
                        stack.remove(stack.size() - 1);
                        added = true;
                        break;
                    }
                    
                    // Case 2: top is stronger
                    else if (Math.abs(top) > Math.abs(num)) {
                        added = true;
                        break;
                    }
                    
                    // Case 3: current is stronger
                    else {
                        stack.remove(stack.size() - 1);
                        continue;
                    }
                } else {
                    break;
                }
            }
            
            if (!added) {
                stack.add(num);
            }
        }
        
        return stack;
    }
}