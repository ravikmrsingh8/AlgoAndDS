package com.example.ds.list.single;

public class Utility {
    public static void printList(Node head) {
        while(head != null) {
            System.out.print(head+"\t");
            head = head.next;
        }
        System.out.println();
    }

    public static Node  addNode(Node head, int data) {
        Node node = new Node(data);
        if(head == null) return node;
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        return head;
    }

    public static Node getList(int[] arr) {
        Node head = null;
        for(int i : arr) {
            head = addNode(head,i);
        }
        return head;
    }
}
