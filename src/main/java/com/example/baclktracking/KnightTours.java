package com.example.baclktracking;


import java.util.Arrays;


/***
 * The knight is placed on the first block of an empty board and,
 * moving according to the rules of chess, must visit each square exactly once.
 * find if Knight can visit all Cells and print the path
 */
public class KnightTours {
    public static void main(String[] args) {
        int N = 8;
        if(knightTour(N)){
            printMoves();
        } else{
            System.out.println("Can't cover all Cells");
        }

    }

    static int[] dx = {1,  2,2,1,-1,-2,-2,-1};
    static int[] dy = {-2,-1,1,2, 2, 1,-1,-2};
    static int[][] moves;

    static boolean isSafe(int i, int j,int N){
        return (i >=0 && i<N)
                && (j>=0 && j<N)
                && (moves[i][j] == -1);
    }

    static void printMoves(){
        for(int[] move : moves){
            System.out.println(Arrays.toString(move));
        }
    }
    static boolean knightTour(int N) {
        moves = new int[N][N];
        for(int[] m : moves)Arrays.fill(m, -1);
        moves[0][0] = 0;
        return tour(0,0,N,1);

    }

    static boolean tour(int i, int j,int N,int move){
        if(move == N*N ) return true;
        for(int m = 0;m<dx.length;m++){
            int ni = i + dx[m];
            int nj = j + dy[m];
            if(isSafe(ni, nj, N)){
                moves[ni][nj] = move;
                if(tour(ni, nj, N, move+1)){
                    return true;
                }
            }
        }
        moves[i][j] = -1;
        return false;
    }
}
