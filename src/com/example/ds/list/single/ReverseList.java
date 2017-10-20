package com.example.ds.list.single;

public class ReverseList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.print("List: ");Utility.printList(head);
        head = reverse(head);
        System.out.print("List: ");Utility.printList(head);

        head = reverseRec(head);
        System.out.print("List: ");Utility.printList(head);
    }
    static Node reverse(Node head) {
        Node prevNode = null;
        Node currNode = head;
        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    static Node reverseRec(Node head) {
        return reverseRec(head,null);
    }

    static Node reverseRec(Node currNode, Node prevNode) {
        if(currNode == null) return prevNode;
        Node nextNode = currNode.next;
        currNode.next = prevNode;
        return reverseRec(nextNode,currNode);
    }
}
