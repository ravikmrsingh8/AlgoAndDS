package com.example.ds.graph.shortestpath.bellmanford;

import java.util.Map;

/*=============
Complexity O(EV)
BellmanFord
1)Set the key of src vertex as 0 , initialise rest as INF
2)Loop V-1 times
    //for each edge (u,v,w) in graph if u.key != INF, call relax
      2.1) for id 0 TO V (excluding V)
         2.1.2) get Vertex u with id = i ,
            2.1.2.1) for each edge(u,v,w) of vertex u if u.key != INF call relax(u,v,w)

relax(u,v,w)
1) if (u.key + w < v.key)
    1.1) v.key = u.key + w
    1.2) v.prev = u.id


hasNegativeCycle(G)
//After bellman ford algorithm is run test if there are negative cycles
1) for each edge(u,v,w) in graph
    1.1) if(u.key + w < v) return true
2) return false


PROOF
in 1st iteration we will get shortest distance for vertices which are at most 1 edge length long
in 2nd iteration we will get shortest distance for vertices which are at most 2 edge length long
....
in V-1 ths iteration we will get shortest distance for vertices which are at most V-1 edge length long
=============== */
public class BellmanFord {
    public static final int INF = Integer.MAX_VALUE;

    public boolean run(Graph g) {
        Vertex v0 = g.vertices.get(0);
        v0.key = 0;
        int V = g.vertices.size();
        //Loop for |V| -1 times
        for (int i = 0; i < V - 1; i++) {
            g.vertices.forEach((id, u) -> {
                u.edges.forEach((v, w) -> {
                    if (u.key != INF) {
                        relax(u, g.vertices.get(v), w);
                    }
                });
            });
        }
        return hasNegativeCycle(g);
    }

    void relax(Vertex u, Vertex v, int w) {
        if (u.key + w < v.key) {
            v.key = u.key + w;
            v.prev = u.id;
        }
    }

    boolean hasNegativeCycle(Graph g) {
        for (Vertex u : g.vertices.values()) {
            if (u.key != INF) {
                for (Map.Entry<Integer, Integer> edge : u.edges.entrySet()) {
                    int v = edge.getKey();
                    int w = edge.getValue();
                    if (u.key + w < g.vertices.get(v).key) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
