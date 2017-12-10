package com.example.ds.list.doublelist;


public class DLL {
    public DNode head;
    public DNode tail;

    public DLL() {
        head = null;
        tail = null;
    }

    public void add(int data) {
        DNode DNode = new DNode(data);
        if (head == null) {
            head = DNode;
            tail = DNode;
            return;
        }
        DNode.prev = tail;
        tail.next = DNode;
        tail = DNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DNode curr = head;
        while (curr != null) {
            sb.append(curr + " ");
            curr = curr.next;
        }
        return sb.toString();
    }
}
