package com.example.ds.graph.shortestpath.dijkstra;


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
        Queue<Vertex> q = new PriorityQueue<>();
        q.offer(v0);
        boolean[] visited = new boolean[G.N];

        while (!q.isEmpty()) {
            Vertex u = q.poll();
            if (!visited[u.id]) {
                visited[u.id] = true;
                u.getEdges().forEach((v, w) -> {
                    if (!visited[v]) {
                        Vertex dest = vertices.get(v);
                        if (u.key + w < dest.key) {
                            relax(u, dest, w);
                            q.offer(dest)
                        }
                    }
                });
            }
        }
    }

    private void relax(Vertex u, Vertex v, int w) {
            v.key = u.key + w;
            v.prev = u.id;
    }
}
