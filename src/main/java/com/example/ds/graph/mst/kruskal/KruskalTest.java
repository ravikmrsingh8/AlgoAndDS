package com.example.ds.graph.mst.kruskal;


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

        Graph g2 = new Graph(4);
        g2.addEdge(0,1, 10);
        g2.addEdge(0,2, 6);
        g2.addEdge(0,3, 5);
        g2.addEdge(1,3, 15);
        g2.addEdge(2,3, 4);

        List<Edge> mst2 = Kruskal.minSpanningTree(g2);
        System.out.println("Min Spanning Tree"+mst2);
    }
}
