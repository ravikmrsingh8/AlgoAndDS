package com.example.ds.graph.mst.prim2;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int size;
    private ArrayList<ArrayList<Edge>> adjList;
    public Graph(int N){
        this.size = N;
        adjList = new ArrayList<>();
        for(int i=0;i<N; i++){
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight));
    }
    public List<Edge> getEdges(int vertex){
        return adjList.get(vertex);
    }
    public int getStartVertex(){
        return 0;
    }
    public List<Edge> getAdjacentEdges(int vertex) {
        return adjList.get(vertex);
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<adjList.size();i++){
            sb.append("["+i+"]").append(adjList.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
