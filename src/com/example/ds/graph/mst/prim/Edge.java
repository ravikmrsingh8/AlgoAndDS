package com.example.ds.graph.mst.prim;


public class Edge {
    private double weight;
    private int src;
    private int dest;
    public Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
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

