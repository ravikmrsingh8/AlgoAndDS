package com.example.ds.graph.repsentation.adjlist.advanced.usingidx;

import java.util.*;

public class Graph {
    private int N;
    private Map<Integer, Vertex> vertices;
    private boolean[] visited;
    public Graph(int N) {
        this.N = N;
        vertices = new HashMap<>();
        for(int i=0; i<N; i++) {
            getVertices().put(i, new Vertex(i));
        }
        visited= new boolean[N];
    }

    public Map<Integer,Vertex> getVertices(){
        return vertices;
    }
    public void addEdge(int src, int dest, int weight) {
        Vertex srcVertex = getVertices().get(src);
        Vertex destVertex = getVertices().get(dest);
        if(!srcVertex.getEdges().containsKey(dest) || srcVertex.getEdges().get(dest) > weight) {
            srcVertex.getEdges().put(dest, weight);
            destVertex.getEdges().put(src, weight);
        }
    }

    public void bfs() {
        Arrays.fill(visited,false);
        for (int i=0; i<N;i++) {
            if(!visited[i]) bfs(i);
        }
    }
    private void bfs(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while(!q.isEmpty()) {
            Vertex curr = getVertices().get(q.poll());
            System.out.print(curr.getIdx()+"\t");
            for(int dest : curr.getEdges().keySet()) {
                if(!visited[dest]){
                    q.offer(dest);
                    visited[dest] = true;
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getVertices().forEach((i,v)->{
            sb.append(v);
            sb.append("\n");
        });
        return sb.toString();
    }
}
