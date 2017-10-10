package com.example.ds.graph.mst.prim;


import java.util.List;

public class PrimTest {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1,4);
        g.addEdge(0,7,8);
        g.addEdge(1,7,11);
        g.addEdge(1,2,8);
        g.addEdge(2,3,7);
        g.addEdge(2,8,2);
        g.addEdge(2,5,4);
        g.addEdge(3,5,14);
        g.addEdge(3,4,9);
        g.addEdge(5,4,10);
        g.addEdge(7,8,7);
        g.addEdge(7,6,1);
        g.addEdge(8,6,6);
        g.addEdge(6,5,2);


        List<Edge> edges =Prim.mst(g);
        System.out.println("Minimum Spanning Tree");
        System.out.println(edges);

    }
}
