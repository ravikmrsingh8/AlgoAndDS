package com.example.ds.graph.mst.prim2;

public class Edge {
    private int src;
    private int dest;
    private int cost;

    public Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("S:").append(getSrc()).append(",");
        sb.append("D:").append(getDest()).append(",");
        sb.append("W:").append(getCost());
        sb.append("]");
        return sb.toString();
    }
}
