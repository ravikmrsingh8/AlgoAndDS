package com.example.ds.list.doublelist;
/*===============================================
10 -> 5 -> 12 -> 7 -> 11
|                |
4 -> 20 -> 13    17 -> 6
     |     |     |
     2     16    9 -> 8
           |     |
           3     19 -> 15
=================================================*/

import java.util.LinkedList;
import java.util.Queue;

public class FlattenMultilevelList {
    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {10, 5, 12, 7, 11},
                {4, 20, 13},
                {17, 6},
                {9, 8},
                {19, 15},
                {2},
                {16},
                {3}
        };
        MNode head = getList(arr);
        flattenList(head);
        printList(head);
    }

    static void flattenList(MNode head) {
        if (head == null) return;
        Queue<MNode> q = new LinkedList<>();
        q.offer(head);

        while (!q.isEmpty()) {
            MNode node = q.poll();
            while (node.next != null) {
                if (node.vert != null) q.offer(node.vert);
                node = node.next;
            }
            if (node.vert != null) q.offer(node.vert);
            if (!q.isEmpty()) node.next = q.peek();
        }
    }

    static MNode getList(int[] arr) {
        MNode head = new MNode(0);
        MNode tail = head;
        for (int i = 0; i < arr.length; i++) {
            tail.next = new MNode(arr[i]);
            tail = tail.next;
        }
        return head.next;
    }

    static MNode getList(int[][] arr) {
        MNode head0 = getList(arr[0]);
        MNode head1 = getList(arr[1]);
        MNode head2 = getList(arr[2]);
        MNode head3 = getList(arr[3]);
        MNode head4 = getList(arr[4]);
        MNode head5 = getList(arr[5]);
        MNode head6 = getList(arr[6]);
        MNode head7 = getList(arr[7]);

        head0.vert = head1;
        head0.next.next.next.vert = head2;
        head1.next.vert = head5;
        head1.next.next.vert = head6;
        head2.vert = head3;
        head3.vert = head4;
        head6.vert = head7;
        return head0;
    }

    static void printList(MNode head) {
        while (head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
    }
}
