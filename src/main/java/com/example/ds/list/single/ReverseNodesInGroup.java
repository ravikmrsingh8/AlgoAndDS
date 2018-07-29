package com.example.ds.list.single;


public class ReverseNodesInGroup {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println("List:");Utility.printList(head);
        System.out.println("List");Utility.printList(reverse(head, 3));
    }
    static Node reverse(Node head, int K) {
        Node newHead = new Node(0);
        newHead.next = head;
        Node prev = newHead;

        while(head != null ) {
            //TODO
        }



        return newHead.next;
    }
}
