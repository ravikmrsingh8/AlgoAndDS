package com.example.ds.graph.toplogicalsort.advanced;


import java.util.*;

public class Graph {
    Map<String, Vertex> vertices;
    Set<String> visited = new HashSet<String>();

    Graph(){
        vertices = new HashMap<>();
    }
    void addVertex(String v) {
        vertices.put(v, new Vertex(v));
    }

    void addEdge(String src, String dest){
        Vertex u = vertices.get(src);
        Vertex v = vertices.get(dest);
        u.adj.add(v);
    }

    boolean isVisited(String v) {
        return visited.contains(v);
    }
    void markVisited(String v) {
        visited.add(v);
    }

    List<String> topologyOrder() {
        Stack<String> stack = new Stack<>();
        visited.clear();

        vertices.forEach((v,V)-> {
            if(!isVisited(v)) {
                markVisited(v);
                dfs(V, stack);
            }
        });

        List<String> topOrder = new ArrayList<>();
        while(!stack.isEmpty()) {
            topOrder.add(stack.pop());
        }
        return topOrder;
    }

    void dfs(Vertex v, Stack<String> stack) {
        v.adj.forEach(adjv ->{
            if(!isVisited(adjv.id)) {
                markVisited(adjv.id);
                dfs(adjv, stack);
            }
        });
        stack.push(v.id);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph\n");
        vertices.forEach((id,V)-> {sb.append(V);});
        return sb.toString();
    }
}
