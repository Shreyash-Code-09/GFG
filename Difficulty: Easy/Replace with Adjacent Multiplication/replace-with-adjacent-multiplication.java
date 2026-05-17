class Solution {
    public void updateArray(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        
        for(int i = 0; i < n; i++) {
            int prev = (i == 0) ? 1 : temp[i - 1];
            int next = (i == n - 1) ? 1 : temp[i + 1];
            
            arr[i] = prev * temp[i] * next;
        }
    }
}