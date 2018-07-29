package com.example.ds.graph.shortestpath.dijkstra2;

public class Edge {
    int src;
    int dest;
    long cost;

    public Edge(int src, int dest, long cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}
