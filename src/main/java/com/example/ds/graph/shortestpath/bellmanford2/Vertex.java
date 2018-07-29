package com.example.ds.graph.shortestpath.bellmanford2;

public class Vertex {
    public int key;
    public int id;
    public int prev;

    public Vertex(int id) {
        this.id = id;
        key = Integer.MAX_VALUE;
        prev = -1;
    }

    @Override
    public String toString() {
        return "Vertex[" + "key=" + key + ", id=" + id + ", prev=" + prev + "]";
    }
}
