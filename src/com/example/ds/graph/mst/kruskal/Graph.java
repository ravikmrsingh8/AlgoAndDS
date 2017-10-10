package com.example.ds.graph.mst.kruskal;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edges;
    private int size;

    public Graph(int N) {
        this.size = N;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public int size() {
        return size;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
