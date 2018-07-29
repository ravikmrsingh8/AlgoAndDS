package com.example.amazon.array;

import java.util.Arrays;

public class FloodFill {
    int[][] grid;
    int R;
    int C;
    FloodFill(int[][] grid){
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
    }

    int[] x = new int[]{1,0,-1,0};
    int[] y = new int[]{0,1,0,-1};

    boolean isSafe(int i, int j, int oldCol) {
        return (i<R && i>=0)
            && (j<C && j>=0)
            && grid[i][j] == oldCol;
    }

    void fillColor(int i, int j,  int oldCol, int newColor){
        grid[i][j] = newColor;
        //System.out.println();
        //showGrid();
        for(int m=0;m<x.length;m++) {
            int ni = i+x[m];
            int nj = j+y[m];
            if(isSafe(ni, nj, oldCol)) {
                fillColor(ni, nj, oldCol, newColor);
            }
        }
    }

    void showGrid(){
        for(int[] g : grid){
            System.out.println(Arrays.toString(g));
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        FloodFill fill = new FloodFill(grid);
        fill.fillColor(4,4, grid[4][4],3);
        fill.showGrid();
    }
}
