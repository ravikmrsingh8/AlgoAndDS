package com.example.ds.graph.mst.prim;

import java.util.HashMap;
import java.util.Map;


public class Vertex {
    int id;
    int key;
    int prev;
    Map<Integer,Edge> edges= new HashMap<>();
    public Vertex(int id) {
        this.id = id;
        key = Integer.MAX_VALUE;
        prev = -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("Vertex"+id).append("]");
        sb.append("[");
        edges.forEach((v,w)->{
            sb.append("[D:").append(v).append(",W:").append(w.cost+"]");
        });
        sb.append("]");
        return sb.toString();
    }
}
