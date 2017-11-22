package com.example.ds.graph.shortestpath.topological;


public class TestDAGShortestPath {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        System.out.println("Graph:\n"+g);
        ShortestPath.find(g, 1);

        System.out.println("Graph:\n"+g);

    }
}
