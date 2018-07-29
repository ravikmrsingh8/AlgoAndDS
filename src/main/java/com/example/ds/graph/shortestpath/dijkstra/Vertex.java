package com.example.ds.graph.shortestpath.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Vertex implements Comparable<Vertex> {
    public int id;
    public boolean visited;
    public int key;
    //All neighbour vertices of this vertex and weight of edge from this vertex;
    public Map<Integer, Integer> edges;
    int prev;

    public Vertex(int id) {
        this.id = id;
        key = Integer.MAX_VALUE;
        edges = new HashMap<>();
        prev = -1;
    }

    public Map<Integer, Integer> getEdges() {
        return edges;
    }

    @Override
    public int compareTo(Vertex o) {
        return key < o.key ? -1 : 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Vertex:");
        sb.append(id);
        sb.append(",minDist:" + key + "]");
        sb.append(",Prev:" + prev + "]");
        sb.append("Edges:[");
        edges.forEach((v, w) -> {
            sb.append(v).append(",").append(w);
        });
        sb.append("]");
        return sb.toString();
    }
}
