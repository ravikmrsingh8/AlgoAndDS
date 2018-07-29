package com.example.ds.list.doublelist;


public class VNode {
    int data;
    VNode next;
    VNode down;
    VNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
