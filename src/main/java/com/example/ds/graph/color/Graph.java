package com.example.ds.graph.color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    List<ArrayList<Integer>> adj = new ArrayList<>();

    int N = 0;
    int[] vertexColor;

    Graph(int N) {
        this.N = N;
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        vertexColor = new int[N];
        Arrays.fill(vertexColor, -1);
    }


    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }


    void color(int[] m){
        System.out.println(Arrays.toString(vertexColor));
        if(colorVertex(0,m, 0)) {
            System.out.println(Arrays.toString(vertexColor));
        } else {
            System.out.println("Not possible");
        }

    }
    boolean isSafe(int v, int c, int[] color){
        if(vertexColor[v] != -1) return false;
        for(int u : adj.get(v)) {
            if(vertexColor[u] == color[c]) return false;
        }
        return true;
    }
    boolean colorVertex(int v, int[] color, int c){

        vertexColor[v] = color[c];
        if(allColoured())return true;

        for(int adjv : adj.get(v)) {
            for(int i=0; i <color.length; i++) {
                if(isSafe(adjv, i, color)){
                    if(colorVertex(adjv, color, i)) return true;
                }
            }
        }
        vertexColor[v] = -1;
        return false;
    }

    boolean allColoured(){
        for(int v: vertexColor){
            if(v == -1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(4,6);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,7);
        g.color(new int[]{0,1,2,3, 4});

    }
}
