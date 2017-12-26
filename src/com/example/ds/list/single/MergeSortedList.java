package com.example.ds.list.single;

public class MergeSortedList {
    public static void main(String[] args) {
        Node head1 = Utility.getList(new int[]{1,20,30,35});
        Utility.printList(head1);

        Node head2 = Utility.getList(new int[]{10,21,24,39});
        Utility.printList(head2);

        Node head = merge(head1,head2);
        Utility.printList(head);
    }

    static Node merge(Node head1, Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        Node temp = new Node(Integer.MAX_VALUE);
        Node newHead = temp;

        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1 == null) temp.next = head2;
        if(head2 == null) temp.next = head1;
        return newHead.next;
    }
}
