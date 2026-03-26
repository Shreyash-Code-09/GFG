class Solution {
    Node prev = null;
    Node head = null;

    Node bToDLL(Node root) {
        inorder(root);
        return head;
    }

    void inorder(Node root) {
        if (root == null) return;

        // Left
        inorder(root.left);

        // Process current node
        if (prev == null) {
            head = root;  // first node
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        // Right
        inorder(root.right);
    }
}