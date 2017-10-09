package com.example.ds.graph.mst;

import com.example.ds.graph.disjointsets.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> minSpanningTree(Graph g) {
        List<Edge> edgeList = g.getEdges();
        Collections.sort(edgeList, (e1, e2)->{
            return e1.weight - e2.weight;
        });
        List<Edge> mstEdges = new ArrayList<>();
        DisjointSet ds = new DisjointSet(g.numVertex);
        int minCost = 0;
        for(Edge edge : g.getEdges()) {
            if(!ds.isConnected(edge.src, edge.dest)) {
                ds.union(edge.src, edge.dest);
                minCost += edge.weight;
                mstEdges.add(edge);
            }
        }
        System.out.println("Minimum Cost :"+minCost);
        return mstEdges;
    }
}
