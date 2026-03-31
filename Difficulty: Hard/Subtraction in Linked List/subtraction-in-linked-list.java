class Solution {

    static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head == null ? new Node(0) : head;
    }

    static int compare(Node l1, Node l2) {
        int n1 = 0, n2 = 0;
        Node t1 = l1, t2 = l2;

        while (t1 != null) { n1++; t1 = t1.next; }
        while (t2 != null) { n2++; t2 = t2.next; }

        if (n1 != n2) return n1 - n2;

        t1 = l1; t2 = l2;
        while (t1 != null) {
            if (t1.data != t2.data) return t1.data - t2.data;
            t1 = t1.next;
            t2 = t2.next;
        }
        return 0;
    }

    static Node subLinkedList(Node head1, Node head2) {

        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        // ensure head1 >= head2
        if (compare(head1, head2) < 0) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node curr = dummy;

        int borrow = 0;

        while (head1 != null) {
            int d1 = head1.data - borrow;
            int d2 = (head2 != null) ? head2.data : 0;

            if (d1 < d2) {
                d1 += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            curr.next = new Node(d1 - d2);
            curr = curr.next;

            head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        Node result = reverse(dummy.next);
        return removeLeadingZeros(result);
    }
}