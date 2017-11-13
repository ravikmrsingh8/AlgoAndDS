package com.example.ds.graph.mst.kruskal;

import com.example.ds.graph.disjointsets.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> minSpanningTree(Graph g) {
        List<Edge> edgeList = g.getEdges();
        if(edgeList.size() < g.size()-1) {
            throw new IllegalStateException("Not a valid Spanning Tree");
        }
        Collections.sort(edgeList, Comparator.comparingInt(e -> e.getWeight()));
        List<Edge> mstEdges = new ArrayList<>();
        DisjointSet ds = new DisjointSet(g.size());
        int minCost = 0;

        for (int i = 0; mstEdges.size() < g.size() - 1; i++) {
            Edge edge = edgeList.get(i);
            if (!ds.isConnected(edge.getSrc(), edge.getDest())) {
                ds.union(edge.getSrc(), edge.getDest());
                minCost += edge.getWeight();
                mstEdges.add(edge);
            }
        }
        System.out.println("Minimum Cost :" + minCost);
        return mstEdges;
    }
}
