package com.example.ds.graph.mst.prim;

public class Edge {
    int src;
    int dest;
    int cost;

    public Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("S:").append(src).append(",");
        sb.append("D:").append(dest).append(",");
        sb.append("W:").append(cost);
        sb.append("]");
        return sb.toString();
    }
}
