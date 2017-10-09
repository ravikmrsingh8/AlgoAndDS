package com.example.ds.graph.disjointsets;


import java.util.Arrays;

public class SimpleDisjointSet {
    private int[] parent;
    private int[] rank;


    public SimpleDisjointSet(int N) {

        parent = new int[N];
        rank = new int[N];
        Arrays.fill(rank, 0);
        for(int i=0;i<N;i++) {
            parent[i] = i;
        }
    }
    public int find(int p){
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        parent[rootQ] = rootP;
    }
}
