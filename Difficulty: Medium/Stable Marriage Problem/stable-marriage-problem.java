import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] wife = new int[n];   // woman -> man
        int[] husband = new int[n]; // man -> woman
        int[] next = new int[n];   // next woman to propose

        Arrays.fill(wife, -1);
        Arrays.fill(husband, -1);

        // rank[w][m] = preference rank of man m for woman w
        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) freeMen.add(i);

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][next[m]++];

            if (wife[w] == -1) {
                wife[w] = m;
                husband[m] = w;
            } else {
                int m1 = wife[w];
                if (rank[w][m] < rank[w][m1]) {
                    wife[w] = m;
                    husband[m] = w;
                    husband[m1] = -1;
                    freeMen.add(m1);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return husband;
    }
}