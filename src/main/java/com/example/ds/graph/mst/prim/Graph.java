package com.example.ds.graph.mst.prim;


import java.util.*;

public class Graph {
    int N;
    List<Vertex> vertices = new ArrayList<>();
    public Graph(int N){
        this.N = N;

        for(int i=0;i<N; i++){
            vertices.add( new Vertex(i));
        }
    }
    public void addEdge(int src, int dest, int cost) {
        Vertex srcv = vertices.get(src);
        Vertex destv = vertices.get(dest);
        if(!srcv.edges.containsKey(dest) || srcv.edges.get(dest).cost > cost) {
            Edge edge1 = new Edge(src, dest, cost);
            Edge edge2 = new Edge(dest, src, cost);
            srcv.edges.put(dest, edge1);
            destv.edges.put(src, edge2);
        }

    }


    List<Edge> prim() {
        boolean[] visited = new boolean[N];

        List<Edge> mstEdges = new ArrayList<>();
        Edge edge0 = new Edge(-1, 0, 0);
        Queue<Edge> pq  =  new PriorityQueue<>(16, (e1, e2)->e1.cost-e2.cost);
        pq.offer(edge0);
        long cost = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(visited[e.dest]) continue;

            cost += e.cost;
            visited[e.dest] = true;
            mstEdges.add(e);

            vertices.get(e.dest).edges.forEach((dest, edge)->{
                if(!visited[dest]) {
                    pq.offer(edge);
                }
            });
        }
        System.out.println("cost :" + cost);
        return mstEdges;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.forEach((V)->{
            sb.append(V).append("\n");
        });
        return sb.toString();
    }
}
