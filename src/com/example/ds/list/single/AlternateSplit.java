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

        Node res1 = head1;
        Node res2 = head2;

        while(head != null ) {
            head1.next = head;
            head1 = head1.next;

            head2.next = head.next;
            head2 = head2.next;

            head = head.next;
            if(head != null) head = head.next;
        }
        if(head1 != null) head1.next = null;
        if(head2 != null) head2.next = null;

        return new WrapHeads(res1.next, res2.next);
    }
}
