package com.example.ds.graph.shortestpath.bellmanford2;

import java.util.List;

public class BellmanFord {
    public boolean run(Graph g) {
        int N = g.vertices.size();
        List<Edge> edges = g.edges;
        edges.get(0).src.key = 0;
        for (int i = 0; i < N - 1; i++) {
            edges.forEach(edge -> {
                Vertex src = edge.src;
                Vertex dest = edge.dest;
                if (src.key + edge.cost < dest.key) {
                    dest.key = src.key + edge.cost;
                    dest.prev = src.id;
                }
            });
        }

        return hasNegativeCycle(g);
    }

    private boolean hasNegativeCycle(Graph g) {
        for (Edge edge : g.edges) {
            Vertex src = edge.src;
            Vertex dest = edge.dest;
            if (src.key + edge.cost < dest.key) return true;
        }
        return false;
    }
}
