package com.example.ds.graph.maxflow.advanced;

import java.util.*;

public class FordFulkerson {
    static int getMaxFlow(Graph g, int src, int sink) {
        int maxFlow = 0;
        Graph rg = getResidualGraph(g);

        while (haveAugmentedPath(rg, src, sink)) {

            //find max possible flow through path
            //i.e (minimum capacity among them)
            int pathFlow = Integer.MAX_VALUE;
            Vertex t = rg.vertices.get(sink);
            do {
                Vertex u = rg.vertices.get(t.prev);
                int cap = u.edges.get(t.id);
                pathFlow = Math.min(cap, pathFlow);
                t = u;
            } while (t.id != src);

            maxFlow += pathFlow;


            // update flows
            // subtract path flow from capacity
            // add path flow in back edge
            t = rg.vertices.get(sink);
            do {
                Vertex u = rg.vertices.get(t.prev);
                int fFlow = u.edges.get(t.id);
                u.edges.put(t.id, fFlow - pathFlow);

                int rFlow = t.edges.get(t.prev);
                t.edges.put(t.prev, rFlow + pathFlow);
                t = u;
            } while (t.id != src);
        }
        return maxFlow;
    }

    static Graph getResidualGraph(Graph g) {
        Graph rGraph = new Graph(g);
        g.vertices.forEach((i, v) -> {
            v.edges.forEach((d, w) -> {
                Vertex dest = rGraph.vertices.get(d);
                if (!dest.edges.containsKey(v.id)) {
                    dest.edges.put(v.id, 0);
                }
            });
        });
        return rGraph;
    }

    static boolean haveAugmentedPath(Graph g, int src, int sink) {
        boolean visited[] = new boolean[g.vertices.size()];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[src] = true;
        q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            g.vertices.get(u).edges.forEach((v, w) -> {
                if (w > 0 && !visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                    g.vertices.get(v).prev = u;
                }
            });
        }
        return visited[sink];
    }
}
