package com.example.ds.graph.maxflow.advanced;


public class TestFordFulkerson {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1,16);
        g.addEdge(0,2,13);
        g.addEdge(1,2,10);
        g.addEdge(2,1,4);
        g.addEdge(1,3,12);
        g.addEdge(3,2,9);
        g.addEdge(2,4,14);
        g.addEdge(4,3,7);
        g.addEdge(3,5,20);
        g.addEdge(4,5,4);
        System.out.println("Graph");
        System.out.println(g);

        int maxFlow = FordFulkerson.getMaxFlow(g, 0, 5);
        System.out.println("Max Flow "+maxFlow);



        Graph g2 = new Graph(7);
        g2.addEdge(0,1, 10);
        g2.addEdge(0,2, 21);
        g2.addEdge(1,2, 3);
        g2.addEdge(1,3, 4);
        g2.addEdge(1,4, 5);
        g2.addEdge(2,3, 5);
        g2.addEdge(2,5, 15);
        g2.addEdge(3,6, 10);
        g2.addEdge(4,6, 7);
        g2.addEdge(5,4, 3);
        g2.addEdge(5,6, 9);

        System.out.println("\nGraph :\n" + g2);
        maxFlow = FordFulkerson.getMaxFlow(g2, 0, 6);
        System.out.println("Max Flow "+maxFlow);

    }
}
