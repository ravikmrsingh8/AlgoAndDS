package com.example.ds.list.single;
/*===================================================================
detectAndFixLoop O(N) space O(N) time
1) one simple solution will be to use set to iterate through list and check if the node is already seen.
 if it is visited before then report that there is a cycle. keep a prev pointer to keep track of prev node once we find a a node that causes cycle then
 break the loop using prev.next to null


detectAndFixLoop(O(1) Space O(N) time)
1) initialise sp and fp as head
2) move fp by 2 steps and sp by 1 step if they meet there is cycle
3) if there is loop then set sp as head, now move sp and fp both by 1 step, keep a prev pointer to fp
4) when sp == fp then we have reached at the start of loop , prev to fp is pointing to the last node
set prev = null to break the loop

 ===================================================================== */
public class DetectAndFixLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        //head.next.next.next.next.next.next = head.next;

        System.out.print("List:");
        Utility.printList(head);
        detectAndFixLoop(head);
        System.out.print("List:");
        Utility.printList(head);
    }

    static void detectAndFixLoop(Node head) {
        Node sp = head;
        Node fp = head;

        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (fp == sp) break;
        }
        // No loop in list return
        if (fp == null || fp.next == null) return;

        Node prev = fp;
        sp = head;
        while (fp != sp) {
            prev = fp;
            fp = fp.next;
            sp = sp.next;
        }

        //break the loop
        prev.next = null;
    }
}
