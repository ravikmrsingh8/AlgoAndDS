package com.example.ds.list.single;

public class DeleteAlternateNodes {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4});
        System.out.print("List:");Utility.printList(head);
        deleteAlternate(head);
        System.out.print("List:");Utility.printList(head);
    }

    static void deleteAlternate(Node head) {
        while(head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
        }
    }
}
