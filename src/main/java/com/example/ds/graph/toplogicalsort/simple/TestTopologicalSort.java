package com.example.ds.graph.toplogicalsort.simple;

import java.util.List;

public class TestTopologicalSort {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);
        System.out.println(g);
        TopologicalSort topology = new TopologicalSort();
        List<Vertex> list = topology.sort(g);
        System.out.println("Topological Order\n"+list);
    }
}
