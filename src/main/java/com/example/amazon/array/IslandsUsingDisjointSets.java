package com.example.amazon.array;

import java.util.HashSet;
import java.util.Set;

public class IslandsUsingDisjointSets {
    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of Islands is: " + countIslands(a, 5, 5));
    }

    static int[] dx = { 0, 1,1,1,0,-1,-1,-1};
    static int[] dy = {-1,-1,0,1,1,-1, 0, 1};
    static boolean isSafe(int[][] a, int i, int j, int R, int C){
        return (i>=0 && i< R)
                && (j>=0 && j< C)
                && (a[i][j] == 1);
    }
    private static int countIslands(int[][] a, int R, int C) {

        DisjointSet set = new DisjointSet(R*C);
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(a[i][j] != 1) continue;
                for(int m=0; m<dx.length; m++){
                    int ni = i + dx[m];
                    int nj = j + dy[m];
                    if(isSafe(a, ni, nj, R, C)){
                        set.union(i*C + j, ni*C + nj);
                    }
                }
            }
        }

        Set<Integer> rep = new HashSet<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(a[i][j] != 0) {
                    rep.add(set.find(i*C + j));
                }
            }
        }
        return rep.size();
    }
}
