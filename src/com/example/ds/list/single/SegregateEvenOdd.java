package com.example.ds.list.single;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1, 4,0,2,5,9});
        System.out.print("List: ");
        Utility.printList(head);
        head = segrgate(head);
        System.out.print("List: ");
        Utility.printList(head);
    }

    static Node segrgate(Node head) {
        Node even = new Node(0);
        Node odd = new Node(0);
        Node tEven = even;
        Node tOdd = odd;

        while (head != null) {
            if (head.data % 2 == 0) {
                tEven.next = head;
                tEven = tEven.next;
            } else {
                tOdd.next = head;
                tOdd = tOdd.next;
            }
            head = head.next;
        }
        if (tEven != null) tEven.next = null;
        tOdd.next = even.next;
        return odd.next;
    }
}
