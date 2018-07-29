package com.example.ds.graph.shortestpath.topological;


import java.util.HashMap;
import java.util.Map;

public class Vertex {
    public static final int INF = Integer.MAX_VALUE;
    public int id;
    public int prev;
    public int key;
    public Map<Integer, Integer> edges;

    public Vertex(int id) {
        this.id = id;
        edges = new HashMap<>();
        prev = -1;
        key = INF;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[V:" + id + ",").append("P:"+prev+",").append("K:"+key+"]");
        sb.append("Edges:");
        edges.forEach((v, w) -> {
            sb.append("[").append(v).append(",").append(w).append("]");
        });
        return sb.toString();
    }
}
