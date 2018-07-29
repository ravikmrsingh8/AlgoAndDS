package com.example.ds.graph.toplogicalsort.advanced;


public class TopologicalSortTest {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");


        g.addEdge("A", "C");
        g.addEdge("B", "C");
        g.addEdge("B", "E");
        g.addEdge("C", "D");
        g.addEdge("D", "F");
        g.addEdge("E", "F");
        g.addEdge("F", "G");

        System.out.println(g);

        System.out.println("Topology order:");
        System.out.println(g.topologyOrder());
    }
}
