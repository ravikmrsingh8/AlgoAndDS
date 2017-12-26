package com.example.ds.list.single;
/*===================================================
findIntersectionNode
1) traverse one list and keep adding elements in set
2) traverse 2nd list and check if element is already there in set if it is, we got the intersection point


findIntersectionNode
1) put all elements of 1st list into stack1, put all elements of list2 into stack2
2) keep popping elements from both stack and compare them, stop when popped elements are not same,
3) next to the popped element is intersection point


findIntersectionPoint
1) find length of list1 L1, list2 as L2
2) if L1 < L2 : swap(H1, H2)
3) move H1 by |L1-L2|
4) keep moving H1 and H2 by 1 step , if H1 == H2 we got the intersection point

===================================================== */
public class IntersectionPoint {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(6);
        head2.next = head1.next.next.next;

        System.out.print("List1:");Utility.printList(head1);
        System.out.print("List2:");Utility.printList(head2);
        Node node = findIntersectionNode(head1, head2);
        System.out.println("Intersection Node:"+node);
    }

    static Node findIntersectionNode(Node head1, Node head2) {
        int L1 = length(head1);
        int L2 = length(head2);
        if(L1 < L2) {
            Node t = head1;
            head1 = head2;
            head2 = t;
        }
        int delta = Math.abs(L1-L2);

        for(int i=0;i<delta; i++){
            head1 = head1.next;
        }

        while(head1 != null && head2 != null) {
            if(head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    static int length(Node head) {
        int N = 0;
        while(head != null) {
            N++;
            head = head.next;
        }
        return N;
    }
}
