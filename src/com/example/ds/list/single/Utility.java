package com.example.ds.list.single;

public class Utility {
    public static void printList(Node head) {
        while(head != null) {
            System.out.print(head+"\t");
            head = head.next;
        }
        System.out.println();
    }
}
