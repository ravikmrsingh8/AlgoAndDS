package com.example.backtracking;

import java.util.Arrays;

public class Sudoku {
    final static int UNASSIGNED = 0;

    public static void main(String[] args) {
        int[][] puzzle = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        puzzle = solve(puzzle, 9);
        printSolution(puzzle);

        int[][] puzzle2 = {
                {0,2,0,0},
                {3,0,0,2},
                {4,0,0,1},
                {0,0,4,0}
        };
        puzzle2 = solve(puzzle2, 4);
        printSolution(puzzle2);
    }

    static int[][] solve(int[][] puzzle, int N) {
        if (solveSudoku(puzzle, N)) {
            return puzzle;
        } else {
            return null;
        }
    }
    static boolean solveSudoku(int[][] puzzle, int N) {
        Cell cell = findUnAssignedCell(puzzle);
        if(cell == null) return true;

        for(int n=1;n<=N;n++){
            if(isSafe( puzzle,N,cell.i,cell.j, n)) {
                puzzle[cell.i][cell.j] = n;
                if(solveSudoku(puzzle, N)) {
                    return true;
                }
                puzzle[cell.i][cell.j] = UNASSIGNED;
            }

        }

        return false;
    }
    static boolean isSafe(int[][] sudoku, int N, int i, int j, int n){
        //check row
        for(int c=0;c<N;c++){
            if(sudoku[i][c] == n) return false;
        }

        //check column
        for(int r=0;r<N;r++){
            if(sudoku[r][j] == n) return false;
        }

        //check box
        int box = (int)Math.sqrt(N);
        int boxRow = i-(i%box);
        int boxCol = j-(j%box);
        for(int r=boxRow;i<boxRow+box;i++){
            for(int c=boxCol;c<boxCol+box;c++){
                if(sudoku[r][c] == n) return false;
            }
        }

        return true;
    }
    static Cell findUnAssignedCell(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j] == UNASSIGNED) return new Cell(i,j);
            }
        }
        return null;
    }

    static class Cell {
        int i;
        int j;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void printSolution(int[][] puzzle) {
        for (int[] row : puzzle) {
            System.out.println(Arrays.toString(row));
        }
    }
}
