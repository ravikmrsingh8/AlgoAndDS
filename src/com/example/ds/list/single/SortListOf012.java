package com.example.ds.list.single;


public class SortListOf012 {
    public static void main(String[] args) {
        Utility.printList(sort(Utility.getList(new int[]{2})));
        Utility.printList(sort(Utility.getList(new int[]{1})));
        Utility.printList(sort(Utility.getList(new int[]{0})));
        Utility.printList(sort(Utility.getList(new int[]{2,1,0,0,1,2,2,2,1,1,0,0})));

    }
    static Node sort(Node head){
        Node[] heads = new Node[]{new Node(0), new Node(0),new Node(0)};
        Node[] tails = new Node[]{heads[0], heads[1], heads[2]};
        while(head != null) {
            tails[head.data].next = head;
            tails[head.data] = tails[head.data].next;
            head = head.next;
        }

        tails[2].next = null;
        tails[1].next = heads[2].next;
        tails[0].next = heads[1].next;
        return heads[0].next;
    }
}
