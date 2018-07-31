package com.example.amazon.list;

public class ReverseListInGroups {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4,5,6,7,8,9,10});
        Utility.printList(head);
        System.out.println();
        Node newHead = reverse(head, 3);
        Utility.printList(newHead);

    }

    static Node reverse(Node head, int k){
        Node prev = null;
        Node cur = head;
        Node next = head;
        int i = 0;
        while(cur != null && i<k ){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        if(cur != null){
            head.next = reverse(cur,k);
        }
        return prev;
    }
}
