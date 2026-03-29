class Solution {
    public int isCircle(String arr[]) {
        int[] in = new int[26];
        int[] out = new int[26];
        
        // Step 1: count in-degree and out-degree
        for (String s : arr) {
            int start = s.charAt(0) - 'a';
            int end = s.charAt(s.length() - 1) - 'a';
            
            out[start]++;
            in[end]++;
        }
        
        // Step 2: check in-degree == out-degree
        for (int i = 0; i < 26; i++) {
            if (in[i] != out[i]) return 0;
        }
        
        // Step 3: check connectivity (DFS)
        boolean[] visited = new boolean[26];
        
        int startNode = -1;
        for (int i = 0; i < 26; i++) {
            if (out[i] > 0) {
                startNode = i;
                break;
            }
        }
        
        dfs(arr, visited, startNode);
        
        // check all used nodes are visited
        for (int i = 0; i < 26; i++) {
            if (out[i] > 0 && !visited[i]) return 0;
        }
        
        return 1;
    }
    
    void dfs(String[] arr, boolean[] visited, int node) {
        visited[node] = true;
        
        for (String s : arr) {
            int start = s.charAt(0) - 'a';
            int end = s.charAt(s.length() - 1) - 'a';
            
            if (start == node && !visited[end]) {
                dfs(arr, visited, end);
            }
        }
    }
}