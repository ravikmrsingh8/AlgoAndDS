package com.example.ds.graph.shortestpath.dijkstra2;

import com.example.utils.FastScanner;

public class Test {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(Test.class.getResourceAsStream("/com/example/ds/graph/largeGraph.txt"));
        int T = in.nextInt();
        while(T-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();
            Graph g = new Graph(N);
            for(int i=0;i<M;i++) {
                g.addEdge(in.nextInt()-1, in.nextInt()-1, in.nextLong());
            }
            int src = in.nextInt();
            g.dijkstra(src-1);

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N; i++) {
                if(i==src-1) continue;
                long key = g.vertices.get(i).key;
                if(key == Constants.INF ) key =  -1;
                sb.append(key+" ");
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }
}
