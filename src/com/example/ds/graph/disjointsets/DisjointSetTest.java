package com.example.ds.graph.disjointsets;


public class DisjointSetTest {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);
        ds.union(1,3);
        ds.union(2,5);
        ds.union(6, 8);
        ds.union(6,5);
        ds.union(3,4);
        ds.union(1,7);
        ds.union(9,0);
        ds.union(5, 8);
        ds.union(5, 9);

        System.out.println(ds);
        System.out.println("Number of Disjoint Sets:"+ds.size());

        System.out.println("1 connected with 8:"+ ds.isConnected(1,8));
        System.out.println(ds);
        System.out.println("2 connected with 8:"+ ds.isConnected(2,8));
        System.out.println(ds);

        System.out.println("3 connected with 8:"+ ds.isConnected(2,5));
        System.out.println(ds);

        System.out.println(ds.description());

    }
}
