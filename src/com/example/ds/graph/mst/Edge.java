package com.example.ds.graph.mst;


public class Edge {
    public int weight;
    public int src;
    public int dest;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[")
                .append(src).append(",")
                .append(dest).append(",")
                .append(weight).append("]")
                .toString();
    }
}

