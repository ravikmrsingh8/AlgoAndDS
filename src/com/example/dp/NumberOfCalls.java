package com.example.dp;

public class NumberOfCalls {
    static int calls = 0;
    public static void main(String[] args) {
        int M = 2;
        int N = 4;
        int[][] tab = new int[M][N];
        rec(tab, M, N, 0, 0);
        System.out.println("Total Calls "+ calls);
    }

    private static void rec(int[][] tab, int M , int N, int i,int j) {
        calls++;
        if(i==M || j==N) return;
        else {
            System.out.println("["+i+","+j+"]");
            rec(tab,M,N,i,j+1) ;
            rec(tab, M, N, i+1,j);
        }
    }
}
