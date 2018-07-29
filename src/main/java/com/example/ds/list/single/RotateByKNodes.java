package com.example.ds.list.single;


public class RotateByKNodes {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{10, 20, 30, 40, 50, 60});
        head = rotate(head, 4);
        Utility.printList(head);

    }

    static Node rotate(Node head, int k) {
        if (k <= 0) return head;
        Node itr = head;
        int pos = 1;
        while (itr != null && pos < k) {
            itr = itr.next;
            pos++;
        }
        if(itr == null) return head;
        Node kthNode = itr;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = head;
        head = kthNode.next;
        kthNode.next = null;
        return head;
    }
}
