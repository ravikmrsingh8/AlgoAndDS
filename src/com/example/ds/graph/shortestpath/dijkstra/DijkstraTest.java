package com.example.ds.graph.shortestpath.dijkstra;


import com.example.utils.FastScanner;


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
        testGraph();
    }
    static void testGraph() {
        FastScanner in = new FastScanner(Dijkstra.class.getResourceAsStream("/com/example/ds/graph/largeGraph.txt"));
        int N = in.nextInt();
        int M = in.nextInt();
        Graph g = new Graph(N);
        for(int i=1;i<=M;i++) {
            g.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
        }
        System.out.println("Graph");
        System.out.println(g);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.run(g,0);
        System.out.println("After Dijkstra");
        System.out.println(g);

        int dest = 4;
        System.out.println("Path for "+dest);
        Vertex v = g.vertices().get(dest);
        do {
            int prevVertex = v.prevVertexId;
            System.out.print(prevVertex+" ");
            v = g.vertices().get(prevVertex);
        }while(v.prevVertexId != -1);
    }
}
