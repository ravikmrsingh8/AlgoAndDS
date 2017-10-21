package com.example.ds.list.single;


import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Node head = Utility.getList(new int[] {1,2,3,2,1});
        System.out.print("Palindrome :"+isPalindrome(head)+"\t");
        Utility.printList(head);

        Node head2 = Utility.getList(new int[]{1,2,3,4,1});
        System.out.print("Palindrome :"+isPalindrome(head2)+"\t");
        Utility.printList(head2);

        head = Utility.getList(new int[]{1,2,3,1});
        System.out.print("Palindrome :"+isPalindrome(head)+"\t");
        Utility.printList(head);

        head = Utility.getList(new int[]{1,2,2,1});
        System.out.print("Palindrome :"+isPalindrome(head)+"\t");
        Utility.printList(head);


        head = Utility.getList(new int[]{3,4,5,5,4,3});
        System.out.print("Palindrome :"+isPalindrome1(head)+"\t");
        Utility.printList(head);

        head = Utility.getList(new int[]{3,4,5,4,3});
        System.out.print("Palindrome :"+isPalindrome1(head)+"\t");
        Utility.printList(head);

        head = Utility.getList(new int[]{3,4,5,2,3});
        System.out.print("Palindrome :"+isPalindrome1(head)+"\t");
        Utility.printList(head);

        head = Utility.getList(new int[]{3,4,5,3});
        System.out.print("Palindrome :"+isPalindrome1(head)+"\t");
        Utility.printList(head);
    }

    //Solution 1
    private static boolean isPalindrome(Node head) {

        //Get Middle Node of List
        Node sPointer = head;
        Node fPointer = head;
        Node firstHalfTail = head;
        while(fPointer != null && fPointer.next != null) {
            firstHalfTail = sPointer;
            sPointer = sPointer.next;
            fPointer  = fPointer.next.next;
        }
        Node middleNode = sPointer;
        Node nextHalfHead = middleNode;
        //If odd number of node, make hextHalfHead as next of middle Node
        if(fPointer != null) {
            nextHalfHead = middleNode.next;
        }

        //Reverse nextHalfNode
        nextHalfHead = reverse(nextHalfHead);
        //Set firstHalf's tail's next as null
        firstHalfTail.next = null;
        //Check if both half are palindrome
        boolean isPal = isEqual(head, nextHalfHead);


        //Restore List
        //reverse second half
        nextHalfHead = reverse(nextHalfHead);

        firstHalfTail.next = nextHalfHead;
        if(fPointer != null) {
            firstHalfTail.next = middleNode;
            middleNode.next = nextHalfHead;
        }
        return isPal;
    }

    private static boolean isEqual(Node head1, Node head2) {
        while(head1!= null && head2 != null) {
            if(head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1 != null) return false;
        if(head2 != null) return false;
        return true;
    }
    private static Node reverse(Node head) {
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = head;
        while(currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    //Solution 2
    static boolean isPalindrome1(Node head) {
        Node nextHalf = getNextHalfHead(head);
        Stack<Node> stack = new Stack<>();
        Node curNode = nextHalf;
        while(curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        curNode = head;
        while(! stack.isEmpty()) {
            if(stack.pop().data != curNode.data) return false;
            curNode = curNode.next;
        }
        return true;
    }

    private static Node getNextHalfHead(Node head) {
        Node sPointer = head;
        Node fPointer = head;
        while(fPointer != null && fPointer.next != null) {
            sPointer = sPointer.next;
            fPointer = fPointer.next.next;
        }
        if(fPointer != null) sPointer = sPointer.next;
        return sPointer;
    }
}
