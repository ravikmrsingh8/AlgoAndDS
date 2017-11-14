package com.example.ds.graph.mst.prim;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    public int idx;
    public int prev;
    public int key;
    public Map<Integer, Integer> edges;

    public Vertex(int idx) {
        this.idx = idx;
        this.prev = -1;
        key = Integer.MAX_VALUE;
        this.edges = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[V:"+idx).append(",").append("Prev:"+prev).append(",Cost:").append(key).append("]");
        edges.forEach((v,w)->{
            sb.append("[").append(v).append(",").append(w).append("]");
        });
        return sb.toString();
    }
}
