package com.example.ds.list.single;

public class MiddleNode {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4,5});
        Utility.printList(head);
        Node node = middleNode(head);
        System.out.println("Middle Node :"+node);

        head = Utility.getList(new int[]{1,2,3,4});
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
