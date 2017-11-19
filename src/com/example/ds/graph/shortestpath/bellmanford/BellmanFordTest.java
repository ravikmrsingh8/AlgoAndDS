package com.example.ds.graph.shortestpath.bellmanford;

public class BellmanFordTest {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1,-1);
        g.addEdge(0,2,4);
        g.addEdge(1,2,3);
        g.addEdge(1,3,2);
        g.addEdge(1,4,2);
        g.addEdge(3,2,5);
        g.addEdge(3,1,1);
        g.addEdge(4,3,-3);
        System.out.println(g);
        BellmanFord ford = new BellmanFord();
        ford.run(g);
        System.out.println(g);

        // Find if there are negative edges
        System.out.println("Testing for negative cycle ");
        System.out.println("Negative Cycle "+(ford.hasNegativeCycle(g)? "found ":"not found"));

    }


}
