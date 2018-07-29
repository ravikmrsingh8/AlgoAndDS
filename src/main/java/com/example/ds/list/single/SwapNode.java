package com.example.ds.list.single;

public class SwapNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Utility.printList(head);
        System.out.print("Swap 4, 2 ");
        head = swapNodes(head, 4, 2);
        Utility.printList(head);
        System.out.print("Swap 1, 5 ");
        head = swapNodes(head, 1,5);
        Utility.printList(head);
    }
    static Node swapNodes(Node head, int x, int y) {
        //Get x and y and their prev DNode
        Node newHead = head;
        Node curX = head;
        Node prevX = null;
        while(curX != null && curX.data != x) {
            prevX = curX;
            curX = curX.next;
        }

        Node curY = head;
        Node prevY = head;
        while(curY != null && curY.data != y) {
            prevY = curY;
            curY = curY.next;
        }

        //If prevX is not null set it's next to curY
        //other wise curX is head , so set curY as new Head
        if(prevX != null) {
            prevX.next = curY;
        } else {
            newHead = curY;
        }

        //Set next pointers of prev nodes
        //If prevY is not null set its next to curX
        //otherwise curY is head, so set newHead as curX
        if(prevY != null) {
            prevY.next = curX;
        } else {
            newHead = curX;
        }

        //Now set the next pointers of cur nodes
        Node temp = curX.next;
        curX.next = curY.next;
        curY.next = temp;

        return newHead;
    }
}
