package com.example.amazon.list;

public class PairWiseSwap {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4});
        Utility.printList(head);
        head = pairWiseSwap(head);
        Utility.printList(head);

        head = Utility.getList(new int[]{1,2,3,4,5});
        Utility.printList(head);
        head = pairWiseSwap(head);
        Utility.printList(head);
    }

    static Node pairWiseSwap(Node head){
        if(head == null || head.next== null) return head;

        Node rem = head.next.next;

        Node newHead = head.next;
        head.next.next = head;
        head.next = pairWiseSwap(rem);
        return newHead;
    }
}
