package com.example.ds.graph.mst.prim;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {
    public static void run(Graph g) {
        boolean visited[] = new boolean[g.N];
        Vertex v0 = g.vertices.get(0);
        v0.key = 0;
        Queue<Vertex> queue = new PriorityQueue<>(16, Comparator.comparingInt(v->v.key));
        queue.offer(v0);
        while(!queue.isEmpty()) {
            Vertex curr = queue.poll();
            visited[curr.idx] = true;
            curr.edges.forEach((v,w)->{
                if(!visited[v]) {
                    Vertex dest = g.vertices.get(v);
                    if(w < dest.key) {
                        dest.key = w;
                        dest.prev = curr.idx;
                    }
                    queue.offer(dest);
                }
            });
        }
    }
}
