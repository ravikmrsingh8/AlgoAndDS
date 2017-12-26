package com.example.ds.list.single;
/*===================================================================
reverse
1)initialise prev = null, and curr= head
2) while curr != null
    2.1) get next node in nextNode variable
    2.2) set cur.next = prev
    2.3) prev = cur
    2.4) cur = nextNode
3) return prev;



recReverse(Node head, Node prev)
1) if head == null return prev
2) get nextNode as head.next
3) set head.next to prev
4) return revReverse(nextNode, head)

===================================================================== */
public class ReverseList {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[]{1,2,3,4,5});
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
