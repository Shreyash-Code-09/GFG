import java.util.*;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[1000];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            int node = curr[0];
            int steps = curr[1];
            
            if(node == end)
                return steps;
            
            for(int num : arr) {
                int newNode = (node * num) % 1000;
                
                if(steps + 1 < dist[newNode]) {
                    dist[newNode] = steps + 1;
                    q.offer(new int[]{newNode, steps + 1});
                }
            }
        }
        
        return -1;
    }
}