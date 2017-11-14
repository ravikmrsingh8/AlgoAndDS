package com.example.ds.graph.repsentation.adjlist.advanced.usingnames;

public class Test {
    public static void main(String[] args) {
        String[] cities = new String[]{
                "Delhi","Agra","Kolkata","Chennai","Mumbai","Varanshi","Merut","Jaipur","Patna","Hyderabad"
        };
        Graph g = new Graph(cities);
        g.addEdges("Delhi", "Hyderabad", 78);
        g.addEdges("Delhi", "Chennai", 80);
        g.addEdges("Delhi", "Mumbai", 40);
        g.addEdges("Delhi", "Kolkata", 10);
        g.addEdges("Hyderabad", "Chennai", 20);
        g.addEdges("Kolkata", "Patna", 60);
        g.addEdges("Varanshi", "Delhi", 10);
        g.addEdges("Varanshi", "Patna", 10);
        System.out.println(g);
        g.bfs();
    }
}
