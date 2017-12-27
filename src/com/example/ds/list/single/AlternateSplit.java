package com.example.ds.list.single;


public class AlternateSplit {
    static class WrapHeads {
        Node head1;
        Node head2;
        WrapHeads(Node head1,Node head2){
            this.head1 = head1;
            this.head2 = head2;
        }
    }
    public static void main(String[] args) {
        Node head = Utility.getList(new int[] {1,2,3,4,5,6,7,8,9});
        Utility.printList(head);

        WrapHeads heads = alternateSplit(head);
        Utility.printList(heads.head1);
        Utility.printList(heads.head2);
    }

    static WrapHeads alternateSplit(Node head) {

        Node head1 = new Node(0);
        Node head2 = new Node(0);

        Node tail1 = head1;
        Node tail2 = head2;

        while(head != null ) {
            tail1.next = head;
            tail1 = tail1.next;

            tail2.next = head.next;
            tail2 = tail2.next;

            head = head.next;
            if(head != null) head = head.next;
        }
        if(tail1 != null) tail1.next = null;
        if(tail2 != null) tail2.next = null;

        return new WrapHeads(head1.next, head2.next);
    }
}
