package com.example.ds.graph.repsentation.adjlist.advanced.usingnames;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {
    private Map<String, Vertex> vertices;
    private int size;
    private Map<String,Boolean> visited;
    public Graph(String[] names) {
        this.size = names.length;
        vertices = new HashMap<>();
        visited = new HashMap<>();
        for(String name: names) {
            vertices.put(name, new Vertex(name));
            visited.put(name,false);
        }
    }
    public void addEdges(String src, String dest, int dist) {
        Vertex v1 = vertices.get(src);
        Vertex v2 = vertices.get(dest);
        if(v1 != null && v2 != null) {
            v1.getEdges().put(dest,dist);
            v2.getEdges().put(src,dist);
        }
    }

    public void bfs() {
        clearVisited();
        for(String  vertex :vertices.keySet()) {
            if(!isVisited(vertex)){
                bfs(vertex);
            }
        }
    }

    public void bfs(String name) {
        Queue<String> q = new LinkedList<>();
        visited.put(name, true);
        q.offer(name);
        while(!q.isEmpty()){
            String node = q.poll();
            System.out.print(node+"\t");
            for(String v : vertices.get(node).getAdjacentVertices()) {
                if(!isVisited(v)) {
                    visited.put(v, true);
                    q.offer(v);
                }
            }
        }
    }

    public int getSize(){
        return size;
    }
    private boolean isVisited(String node) {
        return visited.get(node);
    }
    private void clearVisited(){
        vertices.forEach((key,value)->{
            visited.put(key, false);
        });
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.values().forEach((vertex)->{
            sb.append(vertex);
            sb.append("\n");
        });
        return sb.toString();
    }
}
