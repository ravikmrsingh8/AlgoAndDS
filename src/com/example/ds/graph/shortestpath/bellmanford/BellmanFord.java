package com.example.ds.graph.shortestpath.bellmanford;

import java.util.Map;

/*=============
Complexity O(EV)
=============== */
public class BellmanFord {
    public static final int INF = Integer.MAX_VALUE;

    public boolean run(Graph g) {
        Vertex v0 = g.vertices.get(0);
        v0.key = 0;
        int N = g.vertices.size();
        //Loop for |V| -1 times
        for (int i = 0; i < N - 1; i++) {
            //For Each edge do relax
            for (int j = 0; j < N; j++) {
                Vertex cur = g.vertices.get(j);
                cur.edges.forEach((v, w) -> {
                    Vertex dest = g.vertices.get(v);
                    if (cur.key != INF) {
                        if (cur.key + w < dest.key) {
                            dest.key = cur.key + w;
                            dest.prev = cur.idx;
                        }
                    }
                });
            }
        }
        return hasNegativeCycle(g);
    }

    boolean hasNegativeCycle(Graph g) {
        for (Vertex v : g.vertices.values()) {
            if (v.key != INF) {
                for (Map.Entry<Integer, Integer> edge : v.edges.entrySet()) {
                    int dest = edge.getKey();
                    int weight = edge.getValue();
                    if (v.key + weight < g.vertices.get(dest).key) {
                        System.out.println("[S" + v.idx + ",D:" + dest + ",W:" + weight + "]");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
