package com.example.ds.graph.traversal;
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

public class GraphTraversal {
    public static void main(String[] args) {
        InputStream in = GraphTraversal.class.getResourceAsStream("/com/example/ds/graph/tinyGraph.txt");
        Graph graph = new Graph(in);
        System.out.println("DFS:");
        graph.dfs();

        System.out.println();
        System.out.println("BFS:");
        graph.bfs();
    }
}
