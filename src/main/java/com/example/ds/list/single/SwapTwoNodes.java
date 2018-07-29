package com.example.ds.list.single;

/*====================================================================

1) Find a in node, let this node is x, and its previous is px
2) Find b in node, let this node is y, and its previous is py
3) If x is null or y is null i.e if any of them not found return head
4) fix head - if x is head set head as y, if y is head set head as x
5) fix prev - if px is not null px.next = y, if py is not null py.next = x
6) fix next - swap next pointers of x and y
7) return head
======================================================================*/
public class SwapTwoNodes {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("List:");
        Utility.printList(head);

        System.out.println("Swap(2,4)");
        head = swapNodes(head, 2, 4);
        System.out.print("List:");
        Utility.printList(head);
    }

    static Node swapNodes(Node head, int a, int b) {
        Node x = head;
        Node px = null;
        Node y = head;
        Node py = null;


        while (x != null) {
            if (x.data == a)break;
            px = x;
            x = x.next;
        }

        while (y != null) {
            if (y.data == b) break;
            py = y;
            y = y.next;
        }

        // If any of them is not found return
        if (x == null || y == null) return head;

        //Change head if one of them is head
        if (x == head) {
            head = y;
        } else if (y == head) {
            head = x;
        }

        //fix previous pointers
        if(px != null) {
            px.next = y;
        }
        if(py != null) {
            py.next = x;
        }

        //swap next nodes
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        return head;
    }
}
