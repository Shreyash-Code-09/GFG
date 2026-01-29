class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int x : arr) {
            if (x < min) {
                secondMin = min;
                min = x;
            } else if (x > min && x < secondMin) {
                secondMin = x;
            }
        }
        
        if (secondMin == Integer.MAX_VALUE) {
            ans.add(-1);
            //ans.add(-1);
        } else {
            ans.add(min);
            ans.add(secondMin);
        }
        
        return ans;
    }
}
