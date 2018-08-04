package com.example.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * TYhe N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * For example, following is a solution for 4 Queen problem.
 *   { 0,  1,  0,  0}
 *   { 0,  0,  0,  1}
 *   { 1,  0,  0,  0}
 *   { 0,  0,  1,  0}
 */
public class NQueens {
    public static void main(String[] args) {
        int N = 4;
        List<Position> positions = placeQueens(N);
        System.out.println(positions);
    }

    static List<Position> placeQueens(int N){
        LinkedList<Position> positions = new LinkedList<>();
        placeQueens(N, 0, positions);
        return positions;
    }

    static boolean placeQueens(int N,  int Q, LinkedList<Position> positions){
        if(Q == N) return true;

        for(int col=0;col<N;col++) {
            if(isSafe(Q,col,N,positions)) {
                positions.add(new Position(Q,col));
                if(placeQueens(N, Q+1,positions)){
                    return true;
                }
                positions.pollLast();
            }
        }
        return false;
    }

    static boolean isSafe(int row, int col,int N, List<Position> pos){
        if((row <0 || row>=N) || (col <0 || col>= N)){
            return false;
        }
        for(Position p : pos){
            boolean attacked = (p.row == row)
                    || (p.col == col)
                    || (p.row + p.col == row +col)
                    || (p.row - p.col == row -col);
            if(attacked) return false;
        }
        return true;
    }


    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "("+row +","+col+")";
        }
    }
}
