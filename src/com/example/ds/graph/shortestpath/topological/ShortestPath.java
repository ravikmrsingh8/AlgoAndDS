package com.example.ds.graph.shortestpath.topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*===========================================================
Shortest Path Algorithm in DAG
1)store the topological order of vertices in a list
2)get the src vertex, set its key to 0
3)forEach Vertex u in topological order, if u.key is not INF then
    3.1)forEach edge of u do following
        3.1.1)if cost of edge + current vertex key < destination key ,
              3.1.1.1)update destination's cost
              3.1.1.2)update destination's prev as current node


=============================================================*/
public class ShortestPath {
    private static boolean[] visited;
    private static final int INF = Integer.MAX_VALUE;

    public static void find(Graph g, int src) {
        List<Vertex> vertices = topologicalOrder(g);
        Vertex start = g.vertices.get(src);
        start.key = 0;

        vertices.forEach((u) -> {
            if (u.key != INF) {
                u.edges.forEach((v, w) -> {
                    Vertex dest = g.vertices.get(v);
                    if (u.key + w < dest.key) {
                        dest.key = u.key + w;
                        dest.prev = u.id;
                    }
                });
            }
        });

    }

    private static List<Vertex> topologicalOrder(Graph g) {
        visited = new boolean[g.vertices.size()];
        List<Vertex> list = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();
        g.vertices.keySet().forEach((v) -> {
            if (!visited[v]) process(g, v, stack);
        });
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private static void process(Graph g, int vertex, Stack<Vertex> stack) {
        Vertex V = g.vertices.get(vertex);
        V.edges.forEach((v, w) -> {
            if (!visited[v]) process(g, v, stack);
        });
        visited[V.id] = true;
        stack.push(V);
    }
}
