package com.example.ds.graph.shortestpath.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Vertex implements Comparable<Vertex>{
    public int id;
    public boolean visited;
    public int minDist;
    //All neighbour vertices of this vertex and weight of edge from this vertex;
    public Map<Integer, Integer> edges;
    int prevVertexId;

    public Vertex(int id) {
        this.id = id;
        minDist = Integer.MAX_VALUE;
        edges = new HashMap<>();
        prevVertexId = -1;
    }

    public Map<Integer,Integer> getEdges() {
        return edges;
    }

    @Override
    public int compareTo(Vertex o) {
        return minDist < o.minDist ?-1:1;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("[Vertex:");
        sb.append(id);
        sb.append(",minDist:"+minDist+"]");
        sb.append(",Prev:"+prevVertexId+"]");
        sb.append("Edges:[");
        edges.forEach((v, w)->{sb.append(v).append(",").append(w);});
        sb.append("]");
        return sb.toString();
    }
}
