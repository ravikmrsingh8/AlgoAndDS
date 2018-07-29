package com.example.ds.graph.shortestpath.dijkstra;


import java.util.HashMap;
import java.util.Map;

public class Graph {
    public int N;
    public Map<Integer, Vertex> vertices;

    public Graph(int N) {
        this.N = N;
        vertices = new HashMap<>();
        for (int id = 0; id < N; id++) {
            vertices.put(id, new Vertex(id));
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Vertex srcVtx = vertices.get(src);
        Vertex destVtx = vertices.get(dest);
        if(!srcVtx.getEdges().containsKey(dest) || srcVtx.getEdges().get(dest)> weight) {
            srcVtx.getEdges().put(dest,weight);
            destVtx.getEdges().put(src,weight);
        }
    }

    public Map<Integer, Vertex> vertices() {
        return vertices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");
        vertices.forEach((key,value)->{
            sb.append(value).append("\n");
        });
        return sb.toString();
    }
}
