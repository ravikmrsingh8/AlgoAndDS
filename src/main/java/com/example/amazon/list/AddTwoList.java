package com.example.amazon.list;

public class AddTwoList {
    static Node addTwoLists(Node first, Node second){
        // Your code here
        Node itr = new Node(-1);
        Node newHead = itr;
        int carry =0;
        while(first != null && second != null) {
            int val = carry + first.data + second.data;
            carry = val/10;
            itr.next = new Node(val%10);
            itr = itr.next;
            first= first.next;
            second = second.next;
        }

        Node rem = first == null? second : first;

        while(rem != null) {
            int val = carry + rem.data;
            carry = val/10;

            itr.next = new Node(val%10);
            itr = itr.next;
            rem = rem.next;

        }
        if(carry != 0){
            itr.next = new Node(carry);
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node head1 = Utility.getList(new int[]{9,9,1});
        Node head2 = Utility.getList(new int[]{1,1,9});
        Node head = addTwoLists(head1, head2);
        Utility.printList(head);
    }
}
