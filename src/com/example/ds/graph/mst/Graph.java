package com.example.ds.graph.mst;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Edge> edges;
    public int numVertex;
    public Graph(int N){
        this.numVertex = N;
        edges = new ArrayList<>();
    }
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
