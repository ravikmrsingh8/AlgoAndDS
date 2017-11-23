package com.example.ds.graph.maxflow;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public Map<Integer, Vertex> vertices = new HashMap<>();

    //Copy Graph
    public Graph(Graph g) {
        g.vertices.forEach((i,v)->{
            vertices.put(i,new Vertex(v));
        });
    }
    public Graph(int N) {
        for (int i = 0; i < N; i++) {
            vertices.put(i, new Vertex(i));
        }
    }

    public void addEdge(int s, int d, int cost) {
        vertices.get(s).edges.put(d, cost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.values().forEach((v) -> {
            sb.append(v).append("\n");
        });
        return sb.toString();
    }
}
