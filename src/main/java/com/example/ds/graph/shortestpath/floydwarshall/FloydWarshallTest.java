package com.example.ds.graph.shortestpath.floydwarshall;


import java.util.Map;

public class FloydWarshallTest {
    private static final int INF = Integer.MAX_VALUE;
    private static final int NA = -1;
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 3, 15);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 6);
        g.addEdge(1, 2, -2);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 0, 1);
        System.out.println(g);

        Map<String, Object> result = g.floydWarshall();
        int[][] dist = (int[][]) result.get("d");
        int[][] path = (int[][]) result.get("p");
        System.out.println("Dist");
        printDist(dist);
        System.out.println("Path");
        printPath(path);

    }

    static void printDist(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append("[");
            for (int j = 0; j < arr.length; j++) {
                String val =String.format("%4s",(arr[i][j] == INF? "INF":String.valueOf(arr[i][j])));
                sb.append(val+"\t");
            }
            sb.append("]\n");
        }
        System.out.print(sb.toString());

    }

    static void printPath(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append("[");
            for (int j = 0; j < arr.length; j++) {
                String val =String.format("%4s",(arr[i][j] == NA? "NA":String.valueOf(arr[i][j])));
                sb.append(val+"\t");
            }
            sb.append("]\n");
        }
        System.out.print(sb.toString());

    }
}
