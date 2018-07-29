package com.example.ds.graph.disjointsets;


public class TestSimpleDisjointSet {
    public static void main(String[] args) {
        SimpleDisjointSet ds = new SimpleDisjointSet(10);
        ds.union(1,3);
        ds.union(2,5);
        ds.union(6, 8);
        ds.union(6,5);

        System.out.println("1 connected with 8:"+ ds.isConnected(1,8));
        System.out.println("2 connected with 8:"+ ds.isConnected(2,8));
    }
}
