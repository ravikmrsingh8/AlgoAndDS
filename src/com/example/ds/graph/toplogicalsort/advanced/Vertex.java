package com.example.ds.graph.toplogicalsort.advanced;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Vertex {
    String id;
    Set<Vertex> adj;
    Vertex(String id) {
        this.id = id;
        this.adj = new HashSet<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id+":");
        sb.append("[");

        Iterator<Vertex> itr = adj.iterator();
        while(itr.hasNext()) {
            sb.append(itr.next().id);
            if(itr.hasNext())sb.append(",");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
