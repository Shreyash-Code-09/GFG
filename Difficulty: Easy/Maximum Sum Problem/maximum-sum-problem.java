import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int maxSum(int n) {
        if(n == 0)
            return 0;

        if(memo.containsKey(n))
            return memo.get(n);

        int breakSum = maxSum(n/2) + maxSum(n/3) + maxSum(n/4);

        int ans = Math.max(n, breakSum);

        memo.put(n, ans);

        return ans;
    }
}