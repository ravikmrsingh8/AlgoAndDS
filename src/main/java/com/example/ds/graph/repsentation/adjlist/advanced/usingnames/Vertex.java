package com.example.ds.graph.repsentation.adjlist.advanced.usingnames;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex {
    public String name;
    public Map<String, Integer> edges;
    public Vertex(String name) {
        this.name = name;
        edges = new HashMap<>();
    }
    public Map<String, Integer> getEdges() {
        return edges;
    }
    public Set<String> getAdjacentVertices(){
        return edges.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(name).append("]");
        sb.append("Edges");
        edges.forEach((key,value)->{
            sb.append("[").append(key).append(",").append(value).append("]");
        });
        return sb.toString();
    }
}
