package com.example.ds.list.doublelist;

public class Utilty {
    static void printList(FNode head){
        while(head != null) {
            printDown(head);
            head = head.right;
        }
    }
    static void printRight(FNode head) {
        FNode node = head;
        while(node != null) {
            System.out.print(node+"\t");
            node = node.right;
        }
    }

    static void printDown(FNode head) {
        FNode node = head;
        while(node != null) {
            System.out.print(node+"\t");
            node = node.down;
        }
        System.out.println();
    }

}
