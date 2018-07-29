package com.example.ds.graph.shortestpath.bellmanford2;


public class Edge {
    public Vertex src;
    public Vertex dest;
    public int cost;

    public Edge(Vertex src, Vertex dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}
