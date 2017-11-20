package com.example.ds.graph.shortestpath.bellmanford2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public List<Edge> edges = new ArrayList<>();
    public Map<Integer, Vertex> vertices = new HashMap<>();

    public Graph(int N) {
        for (int i = 0; i < N; i++) vertices.put(i, new Vertex(i));
    }

    public void addEdge(int src, int dest, int cost) {
        Vertex v1 = vertices.get(src);
        Vertex v2 = vertices.get(dest);
        edges.add(new Edge(v1, v2, cost));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.values().forEach((vertex) -> {
            sb.append(vertex);
            sb.append("\n");
        });
        return sb.toString();
    }
}
