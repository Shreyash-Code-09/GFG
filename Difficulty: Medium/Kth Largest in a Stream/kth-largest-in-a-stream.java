import java.util.*;

class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }

            if (pq.size() < k) {
                ans.add(-1);
            } else {
                ans.add(pq.peek());
            }
        }

        return ans;
    }
}