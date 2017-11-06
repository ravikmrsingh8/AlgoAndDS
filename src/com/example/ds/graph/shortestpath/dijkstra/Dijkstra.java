package com.example.ds.graph.shortestpath.dijkstra;


import java.util.*;

public class Dijkstra {
    public void run(Graph G, int src) {
        Map<Integer, Vertex> vertices = G.vertices();
        Vertex v1 = vertices.get(src);
        v1.minDist = 0;
        Queue<Vertex> q = new PriorityQueue<>();
        q.offer(v1);
        while (!q.isEmpty()) {
            Vertex curr = q.poll();
            curr.getEdges().forEach((v,w)->{
                Vertex dest = vertices.get(v);
                if(curr.minDist + w < dest.minDist){
                    dest.minDist = curr.minDist + w;
                    dest.prevVertexId = curr.id;
                    q.offer(dest);
                }
            });
        }
    }
}
