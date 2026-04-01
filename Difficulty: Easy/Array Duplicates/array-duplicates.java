import java.util.*;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                res.add(index + 1);
            } else {
                arr[index] = -arr[index];
            }
        }

        return res;
    }
}