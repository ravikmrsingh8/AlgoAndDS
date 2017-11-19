package com.example.ds.graph.shortestpath.bellmanford;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    public int idx;
    public int key;
    public int prev;
    public Map<Integer, Integer> edges = new HashMap<>();
    public Vertex(int idx) {
        this.idx = idx;
        this.key = Integer.MAX_VALUE;
        this.prev = -1;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("[V:"+idx);
        sb.append(",K:"+key);
        sb.append(",P:"+prev);
        sb.append("]");
        sb.append("EDGE:");
        edges.forEach((v,w)->{
            sb.append("[").append(v).append(",").append(w).append("]");
        });
        return sb.toString();
    }
}
