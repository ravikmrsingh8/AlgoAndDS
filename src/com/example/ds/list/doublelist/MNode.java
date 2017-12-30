package com.example.ds.list.doublelist;


public class MNode {
    public int data;
    public MNode vert;
    public MNode next;

    public MNode(int data) {
        this.data = data;
        vert = null;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
