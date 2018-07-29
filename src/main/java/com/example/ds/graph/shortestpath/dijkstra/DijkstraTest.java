package com.example.ds.graph.shortestpath.dijkstra;

public class DijkstraTest {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1,5);
        g.addEdge(0,3,6);
        g.addEdge(0,2,2);
        g.addEdge(2,3,1);
        g.addEdge(2,4,5);
        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Graph Before Dijkstra");
        System.out.println(g);
        dijkstra.run(g, 0);
        System.out.println("Graph After Dijkstra");
        System.out.println(g);
    }
}
