package com.example.ds.graph.shortestpath.bellmanford;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public int N;
    public Map<Integer, Vertex> vertices;

    public Graph(int N) {
        this.N = N;
        vertices = new HashMap<>();
        for(int i=0;i<N;i++)vertices.put(i,new Vertex(i));

    }
    void addEdge(int src,int dest,int weight){
        Vertex v1 = vertices.get(src);
        Vertex v2 = vertices.get(dest);
        if(v1 != null && v2 != null) {
            v1.edges.put(dest,weight);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");
        vertices.values().forEach(v->{
            sb.append(v).append("\n");
        });
        return sb.toString();
    }
}
