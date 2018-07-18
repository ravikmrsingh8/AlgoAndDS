package com.example.ds.graph.shortestpath.dijkstra;


import javafx.util.Pair;

import java.util.*;

/*========================================================================
Dijkstra

1) set the key of src vertex to 0, initialize other vertex's key as INF
2) create a priority queue and offer source vertex
3) create a boolean visited array
4) while queue is not empty do following
    4.1) poll element u from q
    4.2) if u is not visited do following
        4.2.1) mark the element visited
        4.2.2) for each adjacent vertex v of u having edge of cost w do following
            4.2.2.1) if v is not visited call relax(u, v, w)

relax(u,v,w):
1) if (u.key + w < v.key)
    1.1) v.key = u.key + w
    1.2) v.prev = u.id

==========================================================================*/
public class Dijkstra {
    public void run(Graph G, int src) {
        Map<Integer, Vertex> vertices = G.vertices();
        Vertex v0 = vertices.get(src);
        v0.key = 0;
        Queue<Pair<Integer, Integer>> q = new PriorityQueue<>(16, Comparator.comparing(Pair::getValue));
        q.offer(new Pair<>(0, 0));

        boolean[] visited = new boolean[G.N];

        while (!q.isEmpty()) {
            Pair<Integer, Integer> u = q.poll();

            if (!visited[u.getKey()]) {
                visited[u.getKey()] = true;
                G.vertices.get(u.getKey()).getEdges().forEach((v, w) -> {
                    if (!visited[v]) {
                        Vertex dest = vertices.get(v);
                        if (u.getValue() + w < dest.key) {
                            dest.key = u.getValue() + w;
                            dest.prev = u.getKey();
                            q.offer(new Pair<>(dest.id, dest.key));
                        }
                    }
                });
            }
        }
    }
}
