package com.example.ds.graph.repsentation.adjlist.advanced.usingidx;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private int idx;
    //Edges are represented as set of (dest , weight)
    private Map<Integer, Integer> edges;

    public Vertex(int idx) {
        this.idx = idx;
        this.edges = new HashMap<>();
    }

    public int getIdx() {
        return idx;
    }

    public Map<Integer, Integer> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Vertex" + idx + "][Edges:");
        getEdges().forEach((v, w) -> {
            sb.append("[").append(v).append(",").append(w).append("]");
        });
        sb.append("]");
        return sb.toString();
    }
}
