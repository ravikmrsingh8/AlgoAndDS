package com.example.ds.list.doublelist;

import java.util.Stack;

public class PointArbitPointerToNGE {
    public static void main(String[] args) {
        ANode head = getList(new int[]{7, 1, 6, 2, 6, 4, 3, 1, 8, 10});
        process(head);
        printListWithArbit(head);
    }

    static void printListWithArbit(ANode head) {
        while (head != null) {
            System.out.println("Node:" + head + ", arbitrary:" + head.arbitrary);
            head = head.next;
        }
    }

    static void process(ANode head) {
        Stack<ANode> stack = new Stack<>();
        if (head != null) stack.push(head);
        head = head.next;
        while (head != null) {
            while (!stack.isEmpty() && head.data > stack.peek().data) {
                stack.pop().arbitrary = head;
            }
            stack.push(head);
            head = head.next;
        }
    }

    static class ANode {
        public int data;
        public ANode next;
        public ANode arbitrary;

        public ANode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static ANode getList(int[] arr) {
        ANode head = null;
        for (int i : arr) {
            head = addNode(head, i);
        }
        return head;
    }

    private static ANode addNode(ANode head, int data) {
        if (head == null) return new ANode(data);
        else {
            ANode itr = head;
            while (itr.next != null) itr = itr.next;
            itr.next = new ANode(data);
        }
        return head;
    }


}
