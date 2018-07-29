package com.example.ds.graph.repsentation.adjlist.simple;
/*========================================================
0->[5, 1, 2, 6]
1->[0]
2->[0]
3->[4, 5]
4->[3, 6, 5]
5->[0, 4, 3]
6->[4, 0]
7->[8]
8->[7]
9->[12, 10, 11]
10->[9]
11->[12, 9]
12->[9, 11]
==========================================================*/

import java.io.InputStream;
import java.util.*;

public class Graph {
    private final int numVertex;
    private int numEdge;
    private ArrayList<ArrayList<Integer>> adjList;
    private boolean[] visited;
    public Graph(InputStream is) {
        Scanner in = new Scanner(is);
        this.numVertex = in.nextInt();

        adjList = new ArrayList<>();
        for(int i=0; i<numVertex; i++) {
            adjList.add(new ArrayList<>());
        }
        int edges = in.nextInt();
        for (int i=0;i<edges; i++) {
            addEdge(in.nextInt(), in.nextInt());
        }
        this.visited = new boolean[numVertex];
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }
    public Iterable<Integer> getAdjacentList(int v) {
        return adjList.get(v);
    }


    public void dfs() {
        Arrays.fill(visited, false);
        for(int i=0; i<numVertex;i++) {
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    private void dfs(int i){
        System.out.print(i+"\t");
        visited[i] = true;
        for (int v : getAdjacentList(i)) {
            if(!visited[v])dfs(v);
        }
    }


    public void bfs(){
        Arrays.fill(visited, false);
        for(int i=0; i<numVertex; i++) {
            if(!visited[i]) bfs(i);
        }
    }
    private void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.offer(i);
        while(!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v+"\t");
            for(int w : getAdjacentList(v)) {
                if(!visited[w]){
                    visited[w] = true;
                    q.offer(w);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numVertex; i++) {
            sb.append(i).append("->");
            sb.append(getAdjacentList(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
