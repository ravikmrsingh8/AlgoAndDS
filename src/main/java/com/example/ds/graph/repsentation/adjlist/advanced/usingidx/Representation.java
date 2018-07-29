package com.example.ds.graph.repsentation.adjlist.advanced.usingidx;

import java.util.Scanner;

public class Representation {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1,4);
        g.addEdge(0,2,2);
        g.addEdge(1,2,1);
        g.addEdge(1,3,5);
        g.addEdge(2,4,1);
        g.addEdge(3,4,4);
        System.out.println(g);
        System.out.print("BFS:");g.bfs();

        System.out.println();
        Scanner in = new Scanner(Representation.class.getResourceAsStream("/com/example/ds/graph/largeGraph.txt"));
        int N = in.nextInt();
        int M = in.nextInt();
        Graph g2 = new Graph(N);
        for(int i=0;i<M; i++) {
            g2.addEdge(in.nextInt(),in.nextInt(),in.nextInt());
        }
        in.close();
        System.out.println(g2);
        System.out.print("BFS:");g2.bfs();
    }

}
