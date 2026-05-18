import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> used = new HashSet<>();

        for (int num : arr) {

            if (set.contains(-num)) {

                int a = Math.min(num, -num);
                int b = Math.max(num, -num);

                String key = a + "," + b;

                if (!used.contains(key)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(a);
                    pair.add(b);

                    ans.add(pair);
                    used.add(key);
                }
            }

            set.add(num);
        }

        // Sort final answer
        Collections.sort(ans, (x, y) -> {
            if (!x.get(0).equals(y.get(0)))
                return x.get(0) - y.get(0);

            return x.get(1) - y.get(1);
        });

        return ans;
    }
}