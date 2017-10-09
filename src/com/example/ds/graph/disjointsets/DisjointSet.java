package com.example.ds.graph.disjointsets;


import java.util.*;

public class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int size;
    private int N;
    public DisjointSet(int N) {
        size = N;
        this.N = N;
        rank = new int[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;

        if(rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else if(rank[rootQ] > rank[rootP]) parent[rootP] = rootQ;
        else {
            rank[rootP]++;
            parent[rootQ] = rootP;
        }
        size--;
    }

    // Number of Disjoint Sets
    public int size(){
        return size;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<N ; i++) {
            int root = find(i);
            if(!map.containsKey(root)) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(root, list);
            }
            map.get(root).add(i);
        }
        map.forEach((root, list) ->{
            System.out.println(root+"->"+list);
        });
        return sb.toString();
    }
}
