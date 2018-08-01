package com.example.amazon.array;

public class DisjointSet {
    public int[] parent;
    public int[] rank;
    int size;
    public DisjointSet(int N){
        size = N;
        parent= new int[N];
        rank = new int[N];
        for(int i=0;i<N;i++)parent[i] = i;
    }

    public int find(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q){
        int a = find(p);
        int b = find(q);
        if(a == b) return;
        size--;
        if(rank[a] > rank[b]) {
            parent[b] = a;
        } else if(rank[a] < rank[b]){
            parent[a] = b;
        } else {
            parent[a] = b;
            rank[b]++;
        }
    }
    public int size(){
        return size;
    }
}
