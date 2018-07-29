package com.example.ds.list.single;

public class ReOrderList {
    public Node reorderList(Node A) {
        if(A == null || A.next == null) return A;


        Node head = A;
        Node sp = A;
        Node fp = A;
        while(fp.next != null && fp.next.next != null) {
            fp= fp.next.next;
            sp = sp.next;
        }

        Node afterMid = reverse(sp.next);
        sp.next = null;


        Node h1 = head;
        Node h2 = afterMid;
        Node itr = new Node(-1);
        head = itr;
        while(h1 != null && h2 != null){
            itr.next = h1;
            h1 = h1.next;
            itr = itr.next;
            itr.next = h2;
            h2 = h2.next;
            itr = itr.next;
        }

        if(h1 != null) itr.next = h1;
        return head.next;

    }

    public Node reverse(Node head) {
        Node cur = head;
        Node next = cur;
        Node prev = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4,5,6,7,8,9});
        ReOrderList list = new ReOrderList();
        Node node =list.reorderList(head);

        Utility.printList(node);
    }
}
