package com.example.ds.graph.mst.prim2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex {
    private int idx;
    private int key;
    private int prev;
    private Map<Integer, Integer> edges;
    public Vertex(int idx) {
        this.idx = idx;
        key = Integer.MAX_VALUE;
        prev = -1;
        edges = new HashMap<>();
    }
    public Set<Integer> adjVertices(){
        return edges.keySet();
    }
    public Map<Integer,Integer> getEdges() {
        return edges;
    }

    public int getIdx() {
        return idx;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("Vertex"+idx).append("]");
        sb.append("[");
        getEdges().forEach((v,w)->{
            sb.append("[").append(v).append(",").append("]");
        });
        sb.append("]");
        return sb.toString();
    }
}
