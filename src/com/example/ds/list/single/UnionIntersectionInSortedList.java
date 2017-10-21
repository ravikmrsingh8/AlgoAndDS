package com.example.ds.list.single;


public class UnionIntersectionInSortedList {
    public static void main(String[] args) {
        Node head1 = Utility.getList(new int[]{10,20,33,40,50});
        Utility.printList(head1);

        Node head2 = Utility.getList(new int[]{10,21,33,40});
        Utility.printList(head2);

        Node head = union(head1,head2);
        System.out.print("Union:");Utility.printList( head);


        head1 = Utility.getList(new int[]{10,20,33,40,50});
        Utility.printList(head1);

        head2 = Utility.getList(new int[] {10,21,33,34});
        Utility.printList(head2);

        head = intersection(head1,head2);
        System.out.print("Intersection:");Utility.printList(head);

    }

    //Modify the original list to have union
    // we assume that initially each element ahs distinct values
    static Node union(Node head1, Node head2){
        if(head1 == null) return head1;
        if(head2 == null) return head2;
        Node temp = new Node(Integer.MAX_VALUE);
        Node head = temp;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else  if(head1.data > head2.data){
                temp.next = head2;
                head2 = head2.next;
            } else {
                temp.next = head1;
                head1 = head1.next;
                head2 = head2.next;
            }
            temp = temp.next;

        }
        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;
        return head.next;
    }
    static Node intersection(Node head1, Node head2) {
        if(head1 == null) return head1;
        if(head2 == null) return head2;
        Node temp = new Node(Integer.MAX_VALUE);
        Node head = temp;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                head1 = head1.next;
            } else  if(head1.data > head2.data){
                head2 = head2.next;
            } else {
                temp.next = head1;
                head1 = head1.next;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        temp.next = null;
        return head.next;
    }

}
