package com.example.ds.list.single;

public class Node {
    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringBuilder("[")
                .append(data)
                .append(", N->")
                .append(next==null?"null":next.data)
                .append("]")
                .toString();
    }
}
