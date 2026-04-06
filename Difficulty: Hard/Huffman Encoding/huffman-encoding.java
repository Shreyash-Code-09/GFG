import java.util.*;

class Solution {
    
    static class Node {
        int freq, time;
        Node left, right;
        Node(int f, int t) {
            freq = f;
            time = t;
        }
    }
    
    public ArrayList<String> huffmanCodes(String s, int[] f) {
        int[] timer = {0};
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) return a.freq - b.freq;
            return a.time - b.time;
        });
        
        for (int freq : f) {
            pq.add(new Node(freq, timer[0]++));
        }
        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            // ✅ Parent gets min of both children's times
            Node parent = new Node(left.freq + right.freq, 
                                   Math.min(left.time, right.time));
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        if (s.length() == 1) {
            res.add("0");
            return res;
        }
        
        dfs(pq.peek(), "", res);
        return res;
    }
    
    void dfs(Node root, String code, ArrayList<String> res) {
        if (root.left == null && root.right == null) {
            res.add(code);
            return;
        }
        dfs(root.left, code + "0", res);
        dfs(root.right, code + "1", res);
    }
}