package com.example.ds.graph.toplogicalsort.simple;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    public int id;
    public Set<Vertex>  adj = new HashSet<>();
    public Vertex(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
