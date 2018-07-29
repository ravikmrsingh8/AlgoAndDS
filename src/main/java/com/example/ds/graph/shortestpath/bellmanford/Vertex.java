package com.example.ds.graph.shortestpath.bellmanford;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    public int id;
    public int key;
    public int prev;
    public Map<Integer, Integer> edges = new HashMap<>();
    public Vertex(int idx) {
        this.id = idx;
        this.key = Integer.MAX_VALUE;
        this.prev = -1;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("[u:"+id);
        sb.append(",k:"+key);
        sb.append(",p:"+prev);
        sb.append("]");
        sb.append("EDGE:");
        edges.forEach((v,w)->{
            sb.append("[v:").append(v).append(",w:").append(w).append("]");
        });
        return sb.toString();
    }
}
