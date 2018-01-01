package com.example.ds.list.doublelist;

import java.util.Stack;

/*=======================================================
1 - 2 - 3 - 4
    |
    7 -  8 - 10 - 12
    |    |    |
    9    16   11
    |    |
    14   17 - 18 - 19 - 20
    |                    |
    15 - 23             21
         |
         24
========================================================= */
public class FlattenListVerticalFirst {
    public static void main(String[] args) {
        VNode head = new VNode(1);
        head.next = new VNode(2);
        head.next.next = new VNode(3);
        head.next.next.next = new VNode(4);
        head.next.down = new VNode(7);
        head.next.down.down = new VNode(9);
        head.next.down.down.down = new VNode(14);
        head.next.down.down.down.down
                = new VNode(15);
        head.next.down.down.down.down.next
                = new VNode(23);
        head.next.down.down.down.down.next.down
                = new VNode(24);
        head.next.down.next = new VNode(8);
        head.next.down.next.down = new VNode(16);
        head.next.down.next.down.down = new VNode(17);
        head.next.down.next.down.down.next
                = new VNode(18);
        head.next.down.next.down.down.next.next
                = new VNode(19);
        head.next.down.next.down.down.next.next.next
                = new VNode(20);
        head.next.down.next.down.down.next.next.next.down
                = new VNode(21);
        head.next.down.next.next = new VNode(10);
        head.next.down.next.next.down = new VNode(11);

        head.next.down.next.next.next = new VNode(12);

        flattenList(head);
        printList(head);
    }
    static void flattenList(VNode head) {
        if(head == null) return;
        Stack<VNode> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()) {
            VNode node = stack.pop();

            while(node.down != null) {
                if(node.next != null)stack.push(node.next);
                node.next = node.down;
                node = node.down;
            }
            if(node.next != null) stack.push(node.next);
            if(!stack.isEmpty())node.next = stack.peek();
        }
    }
    static void printList(VNode head) {
        while(head != null) {
            System.out.print(head+", ");
            head = head.next;
        }
    }

}
