package com.example.ds.graph.repsentation.adjlist.simple;


import java.io.InputStream;

public class GraphRepresentation {
    public static void main(String[] args) {
        InputStream in = GraphRepresentation.class.getResourceAsStream("/com/example/ds/graph/tinyGraph.txt");
        Graph graph = new Graph(in);
        System.out.println(graph);
    }
}
