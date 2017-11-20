package com.example.ds.graph.shortestpath.bellmanford2;

public class BellmanFordTest {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        // If we add edges in any order and process them in any order
        // the implementation will fail
        // as Integer.MAX_VALUE + cost will result in some negative value
        // and whole calculation will give us wrong result
        g.addEdge(4,3,-3);
        g.addEdge(1,2, 3);
        g.addEdge(1,4, 2);
        g.addEdge(3,1, 1);
        g.addEdge(0,1, -1);
        g.addEdge(3,2, 5);
        g.addEdge(1,3, 2);
        g.addEdge(0,2, 4);
        BellmanFord ford = new BellmanFord();
        boolean hasNegativeCycle = ford.run(g);
        if(!hasNegativeCycle) {
            System.out.println(g);
        } else {
            System.out.println("Graph has Negative Cycle");
        }
    }
}
