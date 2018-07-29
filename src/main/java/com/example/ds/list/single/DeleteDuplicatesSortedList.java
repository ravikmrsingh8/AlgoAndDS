package com.example.ds.list.single;

public class DeleteDuplicatesSortedList {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{11,11,11,21,43,43,60});
        System.out.print("List:");Utility.printList(head);
        deleteDuplicates(head);
        System.out.print("List:");Utility.printList(head);
    }

    static void deleteDuplicates(Node head) {
        while(head != null) {
            Node cur = head.next;
            while(cur != null && cur.data == head.data) {
                cur = cur.next;
            }
            head.next = cur;
            head = head.next;
        }
    }
}
