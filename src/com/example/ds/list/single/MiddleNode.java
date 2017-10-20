package com.example.ds.list.single;

public class MiddleNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Utility.printList(head);
        Node node = middleNode(head);
        System.out.println("Middle Node :"+node);

        head.next.next.next.next = null;
        Utility.printList(head);
        node = middleNode(head);
        System.out.println("Middle Node :"+node);
    }

    private static Node middleNode(Node head) {
        Node sPointer = head;
        Node fPointer = head;
        while(fPointer != null && fPointer.next != null) {
            sPointer = sPointer.next;
            fPointer = fPointer.next.next;
        }
        return sPointer;
    }
}
