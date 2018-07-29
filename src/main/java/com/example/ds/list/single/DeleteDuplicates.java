package com.example.ds.list.single;

public class DeleteDuplicates {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{ 10, 12, 11, 11, 12, 11, 10 });
        System.out.print("List:");Utility.printList(head);
        deleteDuplicates(head);
        System.out.print("List:");Utility.printList(head);
    }

    static void deleteDuplicates(Node head){
        while(head != null) {
            Node prev = head;
            Node cur = head.next;
            while(cur != null) {
                if(cur.data == head.data) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }
            head = head.next;
        }
    }
}
