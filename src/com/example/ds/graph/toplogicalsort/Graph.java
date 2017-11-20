package com.example.ds.graph.toplogicalsort;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public Map<Integer, Vertex> vertices = new HashMap<>();

    public Graph(int N) {
        for (int i = 0; i < N; i++) {
            vertices.put(i, new Vertex(i));
        }
    }

    public void addEdge(int src, int dest) {
        Vertex v2 = vertices.get(dest);
        Vertex v1 = vertices.get(src);
        v1.dependents.add(v2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node\t Dependent Nodes\n");
        for(int i=0;i<vertices.size(); i++) {
            sb.append("[V"+i+"]").append("\t[");
            vertices.get(i).dependents.forEach((v)->sb.append(v).append(","));
            sb.append("]").append("\n");
        }
        return sb.toString();
    }
}
