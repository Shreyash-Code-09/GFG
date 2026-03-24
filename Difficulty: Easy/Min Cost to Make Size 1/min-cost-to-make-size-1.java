class Solution {
    public int cost(int[] arr) {
        int min = Integer.MAX_VALUE;
        
        // Find minimum element
        for (int num : arr) {
            min = Math.min(min, num);
        }
        
        return (arr.length - 1) * min;
    }
}