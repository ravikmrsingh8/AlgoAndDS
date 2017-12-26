package com.example.ds.graph.mst.prim;

public class PrimTest {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(1, 2, 8);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 5, 14);
        g.addEdge(3, 4, 9);
        g.addEdge(5, 4, 10);
        g.addEdge(7, 8, 7);
        g.addEdge(7, 6, 1);
        g.addEdge(8, 6, 6);
        g.addEdge(6, 5, 2);
        System.out.println("Graph:");
        System.out.println(g);

        Prim.run(g);
        System.out.println("Minimum Spanning Tree");
        System.out.println(g);
        System.out.println("MinCost :" + minCost(g));
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1, 2);
        g2.addEdge(0, 3, 6);
        g2.addEdge(1, 2, 3);
        g2.addEdge(1, 3, 8);
        g2.addEdge(1, 4, 5);
        g2.addEdge(2, 4, 7);
        g2.addEdge(3, 4, 9);
        System.out.println("Graph:");
        System.out.println(g2);
        Prim.run(g2);

        System.out.println("Minimum Spanning Tree");
        System.out.println(g2);
        System.out.println("Min Cost " + minCost(g2));


    }

    static int minCost(Graph g) {
        int minCost = 0;
        for (int i = 0; i < g.N; i++) {
            minCost += g.vertices.get(i).key;
        }
        //System.out.println("MinCost"+minCost);
        return minCost;
    }
}
