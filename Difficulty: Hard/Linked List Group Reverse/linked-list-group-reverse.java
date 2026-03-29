class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null) return null;
        
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        
        // Reverse k nodes (or remaining nodes also)
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        // Recursively reverse next part
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        
        return prev;
    }
}