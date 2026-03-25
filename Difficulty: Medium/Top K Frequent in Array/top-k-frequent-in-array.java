import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        
        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Max Heap (frequency desc, value desc)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0]; // larger number first
                return b[1] - a[1]; // higher frequency first
            }
        );
        
        // Step 3: Push into heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        // Step 4: Get top k
        ArrayList<Integer> result = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }
        
        return result;
    }
}