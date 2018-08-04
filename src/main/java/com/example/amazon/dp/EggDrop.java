package com.example.amazon.dp;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 *
 * When we drop an egg from a floor x, there can be two cases
 * (1) The egg breaks
 * (2) The egg doesn’t break.
 * If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs;
 * so the problem reduces to x-1 floors and n-1 eggs
 * If the egg doesn’t break after dropping from the xth floor,then we only need to check for floors higher than x;
 * so the problem reduces to k-x floors and n eggs.
 *
 * Since we need to minimize the number of trials in worst case, we take the maximum of two cases.
 * We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
 *
 *  N = Number of floors
 *  E = Number of Eggs
 *  trials(E, N) ==> Minimum number of trials needed to find the critical floor in worst case.
 *  trials(E, N) = 1 + min{max(trials(E - 1, X - 1), trials(E,  N - X)): for all x in {1, 2, ..., k}}
 *
 *  1<=N<=50
 *  1<=E<=10
 */
public class EggDrop {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        //Number of floors
        int floors = 50;
        //Number of eggs
        int eggs = 10;

        //evaluate(EggDrop::minOps, eggs, floors);
        evaluate(EggDrop::minOpsDP, eggs, floors);
    }


    static int minOps(int E, int N){
        recCalls++;
        if(N == 1||N ==0) return 1;
        if(E == 1) return N;
        int trials = INF;
        for(int X =1; X<=N; X++){
            int ops = 1 + Math.max( minOps(E-1, X-1), minOps(E, N-X));
            if(ops < trials) trials =ops;
        }
        return trials;
    }


    static int[][] dp= new int[11][51];
    static {
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
    }
    static int minOpsDP(int E, int N){
        recCalls++;
        if(N == 1||N ==0) return 1;
        if(E == 1) return N;
        if(dp[E][N] != -1) return dp[E][N];
        int trials = INF;
        for(int X =1; X<=N; X++){
            int ops = 1 + Math.max(minOpsDP(E-1, X-1) ,minOpsDP(E, N-X));
            if(ops < trials) trials =ops;
        }
        return dp[E][N] = trials;
    }
    //Utility
    static int recCalls = 0;
    static void evaluate(BiFunction<Integer, Integer, Integer> func, int eggs, int floors){
        recCalls =0;
        long start = System.nanoTime();
        System.out.println("Min Trials in worst case: "+func.apply(eggs,floors));
        long end = System.nanoTime();
        System.out.println("Recursive Calls "+recCalls);
        System.out.println("Total Time "+ (end-start)/Math.pow(10, 6)+ "ms");
        System.out.println();
        for(int[] d:dp){
            System.out.println(Arrays.toString(d));
        }
        System.out.println();

    }
}
