package com.example.ds.graph.shortestpath.dijkstra2;

import javafx.util.Pair;

import java.util.*;

public class Graph {
    int N;
    List<Vertex> vertices = new ArrayList<>();
    public Graph(int N){
        this.N = N;
        for(int i=0;i<N;i++){
            vertices.add(new Vertex(i));
        }
    }

    void addEdge(int src, int dest, long cost){
        Vertex u = vertices.get(src);
        Vertex v = vertices.get(dest);
        if(!u.edges.containsKey(dest) || u.edges.get(dest).cost > cost){
            u.edges.put(dest, new Edge(src, dest, cost));
            v.edges.put(src, new Edge(dest, src, cost));
        }
    }

    void dijkstra(int src){
        boolean[] visited = new boolean[vertices.size()];
        Vertex srcVertex = vertices.get(src);
        srcVertex.key = 0;
        Queue<Pair<Integer, Long>> q = new PriorityQueue<>(16,(p1,p2)->(int)(p1.getValue()-p2.getValue()));
        q.offer(new Pair<>(src, 0L));
        while(!q.isEmpty()) {
            Vertex u = vertices.get(q.poll().getKey());
            if(visited[u.id]) continue;

            visited[u.id] = true;
            u.edges.forEach((v, e)->{
                if(!visited[v]) {
                    Vertex dest = vertices.get(v);
                    if(u.key + e.cost < dest.key) {
                        dest.key = u.key + e.cost;
                        dest.prev = u.id;
                        q.offer(new Pair<>(v, dest.key));
                    }
                }
            });
        }
    }
}
