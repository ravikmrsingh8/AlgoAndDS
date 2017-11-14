package com.example.ds.graph.mst.prim2;

import java.util.*;

public class Prim {
    public static List<Edge>  mst(Graph g){
        boolean visited[] = new boolean[g.size()];
        List<Edge> edges = new ArrayList<>();
        int v = g.getStartVertex();
        Queue<Edge> queue = new PriorityQueue<>(16, Comparator.comparingInt(e->e.getCost()));
        visited[v] = true;
        for(Edge e : g.getAdjacentEdges(v)){
            queue.offer(e);
        }
        int minSum = 0;
        while(!queue.isEmpty()) {
            Edge e = queue.poll();
            if(!visited[e.getDest()]) {
                edges.add(e);
                minSum += e.getCost();
                visited[e.getDest()] = true;
                g.getAdjacentEdges(e.getDest()).forEach((e1)->queue.offer(e1));
            }
        }
        System.out.println("Minimum Cost:"+minSum);
        return edges;
    }
}
