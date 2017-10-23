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
        if(head == null) return true;

        //Get tail of first half of List
        Node sPointer = head;
        Node fPointer = head;
        Node tail$1 = head;
        while(fPointer != null && fPointer.next != null) {
            tail$1 = sPointer;
            sPointer = sPointer.next;
            fPointer  = fPointer.next.next;
        }
        Node head$2 = tail$1.next;
        Node middle = null;
        //If odd number of node, get middleNode
        if(fPointer != null) {
            middle = tail$1.next;
            head$2 = middle.next;
        }

        //Reverse nextHalfNode
        head$2 = reverse(head$2);
        //Set firstHalf's tail's next as null
        tail$1.next = null;
        //Check if both half are palindrome
        boolean isPal = isEqual(head, head$2);

        //Restore List
        head$2 = reverse(head$2);
        tail$1.next = head$2;
        //if middle node include it in list
        if(middle != null) {
            tail$1.next = middle;
            middle.next = head$2;
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
