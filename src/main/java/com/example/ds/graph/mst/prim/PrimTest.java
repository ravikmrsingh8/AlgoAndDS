package com.example.ds.graph.mst.prim;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimTest {
    public static void main(String[] args) throws FileNotFoundException {
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
        g.prim();
        //System.out.println("Graph:");
        //System.out.println(g);
        //List<Edge> edges =g.prim();
        //System.out.println("Minimum Spanning Tree");
        //System.out.println(edges);

        g = new Graph(5);
        g.addEdge(0,1,2);
        g.addEdge(0,3,6);
        g.addEdge(1,2,3);
        g.addEdge(1,3,8);
        g.addEdge(1,4,5);
        g.addEdge(2,4,7);
        g.addEdge(3,4,9);
        //System.out.println("Graph:");
        //System.out.println(g2);
        //List<Edge> edges2 =g.prim();
        //System.out.println("Minimum Spanning Tree");
        //System.out.println(edges2);
        g.prim();

        Scanner in = new Scanner(new FileInputStream("input.txt"));
        int N = in.nextInt();
        int M = in.nextInt();

        g = new Graph(N);
        for(int i=0;i<M;i++) {
            g.addEdge(in.nextInt()-1, in.nextInt()-1, in.nextInt());
        }
        g.prim();

    }
}
