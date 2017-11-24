package com.example.ds.graph.maxflow.adjm;


public class Graph {
    public int[][] adjMat;

    public Graph(int N) {
        adjMat = new int[N][N];
    }

    public Graph(Graph g) {
        int N = g.adjMat.length;
        adjMat = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adjMat[i][j] = g.adjMat[i][j];
            }
        }
    }

    public void addEdge(int src, int dest, int cap) {
        adjMat[src][dest] = cap;
    }
}
