class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int num : arr) {
            ans.add(num);
        }
        
        ans.sort((a, b) -> Integer.bitCount(b) - Integer.bitCount(a));
        
        return ans;
    }
}