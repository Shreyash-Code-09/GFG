class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long ans = 0;
        
        for(int bit = 0; bit < 32; bit++) {
            long one = 0;
            long zero = 0;
            
            for(int num : arr) {
                if((num & (1 << bit)) != 0)
                    one++;
                else
                    zero++;
            }
            
            ans += (one * zero * (1L << bit));
        }
        
        return ans;
    }
}