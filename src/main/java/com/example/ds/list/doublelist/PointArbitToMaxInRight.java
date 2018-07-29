package com.example.ds.list.doublelist;


public class PointArbitToMaxInRight {
    public static void main(String[] args) {
        ANode head = getList(new int[]{7, 1, 6, 8, 6, 4, 3, 1, 2});
        process(head);
        printListWithArbit(head);
    }

    static void printListWithArbit(ANode head) {
        while (head != null) {
            System.out.println("Node:" + head + ", arbitrary:" + head.arbitrary);
            head = head.next;
        }
    }

    static ANode process(ANode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        head.arbitrary = process(head.next);
        return head.data > head.arbitrary.data? head: head.arbitrary;
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
