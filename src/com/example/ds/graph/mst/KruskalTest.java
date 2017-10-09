package com.example.ds.graph.mst;


import java.util.List;

public class KruskalTest {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(4,6,6);
        g.addEdge(5,6,8);
        g.addEdge(1,5,2);
        g.addEdge(0,4,6);
        g.addEdge(1,6,9);
        g.addEdge(0,2,2);
        g.addEdge(1,2,5);
        g.addEdge(1,3,9);
        g.addEdge(2,6,1);
        List<Edge> mst = Kruskal.minSpanningTree(g);
        System.out.println("Minimum Spanning Tree:\n"+mst);
    }
}
