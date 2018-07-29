package com.example.ds.list.single;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int tc = 1000;
        System.out.println("Running " + tc + " Test cases ");

        for (int i = 0; i < tc; i++) {
            int N = 10000;
            Node head = getList(N);
            //Utility.printList(head);
            head = mergeSort(head);
            //System.out.println();
            //Utility.printList(head);
            //System.out.println(isSorted(head)? "Pass":"Fail");
            if (!isSorted(head)) {
                System.out.println("Fail");
                System.out.println("List length" + N);
                System.out.println("List :");
                Utility.printList(head);
            }
            break;
        }
        System.out.println("Done!");

    }


    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = midNode(head);
        head = mergeSort(head);
        mid = mergeSort(mid);
        return merge(head, mid);
    }

    static Node midNode(Node head) {
        Node sp = head;
        Node fp = head;
        Node p = head;
        while (fp != null && fp.next != null) {
            p = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        p.next = null;
        return sp;
    }

    static Node merge(Node head1, Node head2) {

        Node head = new Node(0);
        Node tail = head;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 == null) tail.next = head2;
        if (head2 == null) tail.next = head1;
        return head.next;
    }

    static Node getList(int size) {
        int arr[] = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(1000);
        return Utility.getList(arr);
    }

    static boolean isSorted(Node head) {
        while (head.next != null) {
            if (head.data > head.next.data) return false;
            head = head.next;
        }
        return true;
    }
}
