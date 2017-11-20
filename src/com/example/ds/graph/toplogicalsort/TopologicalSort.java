package com.example.ds.graph.toplogicalsort;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*====================================================================================
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
such that for every directed edge uv, vertex u comes before v in the ordering.
Topological Sorting for a graph is not possible if the graph is not a DAG.
====================================================================================== */
public class TopologicalSort {
    boolean[] visited;

    List<Vertex> sort(Graph g) {
        visited = new boolean[g.vertices.size()];
        Stack<Vertex> stack = new Stack<>();
        g.vertices.forEach((v, V) -> {
            if (!visited[v]) {
                sort(V, stack);
            }
        });

        List<Vertex> vertices = new ArrayList<>();
        while (!stack.isEmpty()) {
            vertices.add(stack.pop());
        }
        return vertices;
    }

    private void sort(Vertex V, Stack<Vertex> stack) {
        V.dependents.forEach(v -> {
            if (!visited[v.id]) {
                sort(v, stack);
            }
        });
        stack.push(V);
        visited[V.id] = true;
    }
}
