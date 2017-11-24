package com.example.ds.graph.maxflow.adjm;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    static int[] parent;

    static int findMaxFlow(Graph g, int src, int dest) {
        int N = g.adjMat.length;
        parent = new int[N];
        Graph rg = new Graph(g);
        int maxFlow = 0;
        while (hasAugmentedPath(rg, src, dest)) {
            int flow = Integer.MAX_VALUE;
            for (int i = dest; i != src; i = parent[i]) {
                flow = Math.min(flow, rg.adjMat[parent[i]][i]);
            }
            maxFlow += flow;
            for (int i = dest; i != src; i = parent[i]) {
                rg.adjMat[parent[i]][i] -= flow;
                rg.adjMat[i][parent[i]] += flow;
            }
        }
        return maxFlow;
    }


    static boolean hasAugmentedPath(Graph g, int src, int dest) {
        int[][] adjMat = g.adjMat;
        boolean[] visited = new boolean[adjMat.length];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < adjMat.length; v++) {
                if (!visited[v] && adjMat[u][v] > 0) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.offer(v);
                }
            }
        }
        return visited[dest];
    }
}
