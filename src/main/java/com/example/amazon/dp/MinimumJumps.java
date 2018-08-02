package com.example.amazon.dp;

import java.util.Arrays;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array
 * Input:[1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
 * Output:3
 */
public class MinimumJumps {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] moves = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int jumps = findMinJumps(moves);
        if(jumps != INF) {
            System.out.println("Min Jumps :"+(jumps));
        } else{
            System.out.println("No Jump possible to reach end.");
        }


        moves = new int[]{0, 3, 5, 8};
        jumps = findMinJumps(moves);
        if(jumps != INF) {
            System.out.println("Min Jumps :"+(jumps));
        } else{
            System.out.println("No Jump possible to reach end.");
        }
    }

    static int findMinJumps(int[] moves){

        int N = moves.length;
        int[] jumps = new int[N];
        Arrays.fill(jumps,INF);
        jumps[0] = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1; j <= moves[i]+i && j<N; j++){
                if(jumps[i]==INF)continue;
                if(jumps[j] > jumps[i]+1)jumps[j] = jumps[i]+1;
            }
        }
        return jumps[N-1];
    }
}
