package com.example.ds.list.doublelist;

import java.util.HashMap;
import java.util.Map;

public class CloneList {
    public static void main(String[] args) {
        RNode head = new RNode(1);
        head.next = new RNode(2);
        head.next.next = new RNode(3);
        head.next.next.next = new RNode(4);
        head.next.next.next.next = new RNode(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        System.out.println("List :");
        printList(head);

        RNode cHead = clone(head);
        System.out.println("\nCloned List :");
        printList(cHead);

    }

    static RNode clone(RNode head){
        Map<RNode, RNode> map = new HashMap<>();
        RNode itr = head;
        while(itr != null) {
            map.put(itr, new RNode(itr.data));
            itr = itr.next;
        }
        itr = head;
        while(itr != null) {
            RNode clone = map.get(itr);
            clone.next = map.get(itr.next);
            clone.random = map.get(itr.random);
            itr = itr.next;
        }
        return map.get(head);
    }

    static void printList(RNode head) {
        while (head != null) {
            System.out.println((head.data) + " R: " + (head.random != null ? head.random.data : "null"));
            head = head.next;
        }
    }
}
