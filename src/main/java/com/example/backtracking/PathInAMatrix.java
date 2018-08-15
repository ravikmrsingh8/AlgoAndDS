package com.example.backtracking;

import java.util.LinkedList;

/**
 *
 * The problem is to print all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down.
 * Input : 1 2 3
 *         4 5 6
 * Output : 1 4 5 6
 *          1 2 5 6
 *          1 2 3 6
 *
 * Input : 1 2
 *         3 4
 * Output : 1 2 4
 *          1 3 4
 */
public class PathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix= {
                {1, 2, 3},
                {4, 5, 6}
        };
        printPath(matrix,2, 3);
    }

    static void printPath(int[][] matrix, int R, int C){
        LinkedList<Integer> path = new LinkedList<>();
        printPath(matrix,R,C,0,0,path);
    }
    static int[] di={0,1};
    static int[] dj={1,0};
    static void printPath(int[][] m, int R, int C, int i,int j, LinkedList<Integer> path){
        path.add(m[i][j]);
        if(i==R-1 && j == C-1) {
            System.out.println(path);
            return;
        }

        for(int d=0;d<di.length;d++){
            int ni = i+ di[d];
            int nj = j +dj[d];
            if(ni>=0 && ni< R && nj >=0 && nj <C){
                printPath(m,R,C,ni,nj,path);
                path.pollLast();
            }
        }

    }
}
