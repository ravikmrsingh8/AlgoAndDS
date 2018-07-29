package com.example.ds.graph.maxflow.advanced;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    public int id;
    public int prev;
    public Map<Integer, Integer> edges = new HashMap<>();


    public Vertex(Vertex v) {
        this.id = v.id;
        this.prev = v.prev;
        v.edges.forEach((d, w) -> {
            edges.put(d, w);
        });
    }

    public Vertex(int id) {
        this.id = id;
        this.prev = -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[V" + id + "]Edge");
        edges.forEach((v, w) -> {
            sb.append("[" + v + "," + w + "]");
        });
        return sb.toString();
    }
}
