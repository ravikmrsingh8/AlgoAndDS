package com.example.ds.graph.toplogicalsort.simple;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*====================================================================================
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
such that for every directed edge uv, vertex u comes before v in the ordering.
Topological Sorting for a graph is not possible if the graph is not a DAG.

sort()
1) create a boolean matrix of size as number of vertices, initialize all elements to false
2) create a stack
3) for each vertex if they are not visited mark them visited and call dfs on them, pass Vertex and stack as parameter
4) pop each element from stack and print them

dfs(Vertex, Stack)
1) for each adjacent vertex of V, if they are not visited mark them visited and call dfs(adjV, Stack) on them
2) push current Vertex into stack
====================================================================================== */
public class TopologicalSort {
    boolean[] visited;

    List<Vertex> sort(Graph g) {
        visited = new boolean[g.vertices.size()];
        Stack<Vertex> stack = new Stack<>();
        g.vertices.forEach((v, V) -> {
            if (!visited[v]) {
                visited[v] = true;
                dfs(V, stack);
            }
        });

        List<Vertex> vertices = new ArrayList<>();
        while (!stack.isEmpty()) {
            vertices.add(stack.pop());
        }
        return vertices;
    }

    private void dfs(Vertex V, Stack<Vertex> stack) {
        V.adj.forEach(v -> {
            if (!visited[v.id]) {
                visited[v.id] = true;
                dfs(v, stack);

            }
        });
        stack.push(V);
    }
}
