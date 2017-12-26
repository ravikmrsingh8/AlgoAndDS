package com.example.ds.graph.shortestpath.floydwarshall;


import java.util.Arrays;
import java.util.HashMap;
import  java.util.Map;
public class Graph {
    int N;

    int[][] g;
    int[][] d;
    int[][] path;

    private static final int INF = Integer.MAX_VALUE;

    Graph(int N) {
        this.N = N;
        g = new int[N][N];
        d = new int[N][N];
        path = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) g[i][j] = INF;
                path[i][j] = -1;
            }
        }
    }

    void addEdge(int src, int dest, int cost) {
        g[src][dest] = cost;
        path[src][dest] = src;
    }

    Map<String, Object> floydWarshall() {
        for (int i = 0; i < N; i++) {
            d[i] = Arrays.copyOf(g[i], N);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (d[i][k] != INF && d[k][j] != INF) {
                        if (d[i][j] > d[i][k] + d[k][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }

        Map<String, Object> res = new HashMap<>();
        res.put("d", d);
        res.put("p", path);
        return res;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distance Graph\n");
        for (int i = 0; i < N; i++) {
            sb.append("[");
            for (int j = 0; j < N; j++) {
                String val =String.format("%4s",(g[i][j] == INF? "INF":String.valueOf(g[i][j])));
                sb.append(val+"\t");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

}
