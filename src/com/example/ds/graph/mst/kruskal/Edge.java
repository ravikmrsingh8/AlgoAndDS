package com.example.ds.graph.mst.kruskal;


public class Edge {
    private int weight;
    private int src;
    private int dest;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getWeight() {
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

