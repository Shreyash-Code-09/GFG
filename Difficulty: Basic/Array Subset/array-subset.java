class Solution {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Store frequency of elements in a[]
        for(int num : a){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Check elements of b[]
        for(int num : b){
            if(!map.containsKey(num) || map.get(num) == 0){
                return false;
            }
            
            map.put(num, map.get(num) - 1);
        }
        
        return true;
    }
}