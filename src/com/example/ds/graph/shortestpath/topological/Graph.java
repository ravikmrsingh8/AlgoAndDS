package com.example.ds.graph.shortestpath.topological;


import java.util.HashMap;
import java.util.Map;

public class Graph {
    public Map<Integer, Vertex> vertices = new HashMap<>();

    public Graph(int N) {
        for (int i = 0; i < N; i++) {
            vertices.put(i, new Vertex(i));
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Vertex v = vertices.get(src);
        v.edges.put(dest, weight);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.values().forEach(v->{
            sb.append(v).append("\n");
        });
        return sb.toString();
    }
}
