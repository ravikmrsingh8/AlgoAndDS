package com.example.ds.heap.example;

public class Topic  {
    public int id;
    public int count;
    public Topic(int id){
        this.id = id;
        count = 1;
    }
    @Override
    public String toString() {
        return "[id:"+id+",Count:"+count+"]";
    }
}