package com.example.ds.list.doublelist;


public class FNode {
    public FNode right;
    public FNode down;
    public int data;
    public FNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
