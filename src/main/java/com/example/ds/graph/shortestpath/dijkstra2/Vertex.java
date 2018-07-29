package com.example.ds.graph.shortestpath.dijkstra2;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    int id;
    Map<Integer, Edge> edges = new HashMap<>();
    int prev;
    long key;
    public Vertex(int id){
        this.id = id;
        prev = -1;
        key = Integer.MAX_VALUE;
    }


}
