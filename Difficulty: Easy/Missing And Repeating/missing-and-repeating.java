import java.util.*;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;

        long sum = 0, sumSq = 0;
        for (int num : arr) {
            sum += num;
            sumSq += (long) num * num;
        }

        long S = (long) n * (n + 1) / 2;
        long P = (long) n * (n + 1) * (2 * n + 1) / 6;

        long diff = S - sum;          // x - y
        long diffSq = P - sumSq;      // x^2 - y^2

        long sumXY = diffSq / diff;   // x + y

        long missing = (diff + sumXY) / 2;
        long repeating = sumXY - missing;

        ArrayList<Integer> res = new ArrayList<>();
        res.add((int) repeating);
        res.add((int) missing);

        return res;
    }
}