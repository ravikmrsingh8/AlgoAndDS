package com.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * /**
 *  *
 *  * TYhe N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 *  * For example, following is a solution for 4 Queen problem.
 *  *   { 0,  1,  0,  0}
 *  *   { 0,  0,  0,  1}
 *  *   { 1,  0,  0,  0}
 *  *   { 0,  0,  1,  0}
 *  */

public class NQueens2 {
    public static void main(String[] args) {
        int N = 8;
        int[][] grid = placeQueens(N);
        if(grid != null){
            printGrid(grid);
        } else {
            System.out.println("No Solution Possible");
        }
    }

    static int[][] placeQueens(int N){
        int[][] grid= new int[N][N];
        if(placeQueens(grid,0,N))return grid;
        return null;
    }

    static boolean placeQueens(int[][] grid,int Q, int N){
        if(Q==N) return true;
        for(int c=0;c<N;c++){
            if(isSafe(Q,c,grid, N)){
                grid[Q][c] = 1;
                if(placeQueens(grid,Q+1,N)){
                    return true;
                }
                grid[Q][c] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int i, int j, int[][] grid,int N){
        List<Position> queens = new ArrayList<>();
        for(int r=0;r<i;r++){
            for(int c=0;c<N;c++){
                if(grid[r][c] == 1)queens.add(new Position(r,c));
            }
        }

        for(Position p : queens){
            boolean attacked = (p.row == i)
                    ||(p.col==j)
                    ||(p.row-p.col) == (i-j)
                    ||(p.row + p.col) == (i+j);
            if(attacked) return false;
        }
        return true;
    }
    static void  printGrid(int[][] grid){
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
