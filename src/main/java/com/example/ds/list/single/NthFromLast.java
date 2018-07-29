package com.example.ds.list.single;

public class NthFromLast {
    public static void main(String[] args) {
        Node head1 = Utility.getList(new int[]{1,2,3,4,5,6,7});
        Node head2 = Utility.getList(new int[]{1,2,3,4});
        Node head3 = Utility.getList(new int[]{});
        System.out.println(findNthNodeFromLast(head1, 4));
        System.out.println(findNthNodeFromLast(head2, 4));
        System.out.println(findNthNodeFromLast(head3, 4));


    }

    static Node findNthNodeFromLast(Node head, int n) {
        Node aPtr = head;
        Node bPtr = head;
        while (head != null) {
            if (n > 0) {
                aPtr = aPtr.next;
                n--;
            } else {
                bPtr = bPtr.next;
            }
            head = head.next;
        }
        if (n > 0) return null;
        return bPtr;
    }

}
