package com.example.amazon.dp;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Given an integer N denoting the Length of a line segment.
 * you need to cut the line segment in such a way that the cut length of a line segment each time is integer either x , y or z.
 * and after performing all cutting operation the total number of cut segments must be maximum.
 * find number of cuts needed
 */
public class MaxCuts {
    static int recCalls=0;
    public static void main(String[] args) {
        System.out.println("Recursion");
        evaluate(MaxCuts::maxCuts,new int[]{5,2,3},400);
        evaluate(MaxCuts::maxCuts,new int[]{2,1,1},400);

        System.out.println("DP");
        evaluate(MaxCuts::maxCutsDP,new int[]{5,2,3},400);
        evaluate(MaxCuts::maxCutsDP,new int[]{2,1,1},400);
    }

    //Recursive Solution
    static int max=0;
    static int maxCuts(int[] cuts, int N){
        max=0;
        return maxCuts(N,cuts,cuts.length, 0);

    }
    static int maxCuts(int rem, int[] cuts, int N, int cut){
        recCalls++;
        if(rem == 0) return Math.max(max, cut);
        if( rem <0 || N == 0) return max;

        return Math.max(maxCuts(rem, cuts, N-1, cut),
                maxCuts(rem-cuts[N-1], cuts, N, cut+1));
    }


    //DP Solution
    static int[][] dp;
    static int maxCutsDP(int[] cuts,  int rem){
        recCalls=0;
        max  =0;
        dp = new int[rem+1][cuts.length+1];
        for(int[] d :dp)Arrays.fill(d,-1);
        return maxCutsDP(rem,cuts,cuts.length,0);
    }


    private static int maxCutsDP(int rem, int[] cuts, int N,  int cut) {
        recCalls++;
        if(rem < 0 || N == 0) return max;
        if(rem == 0){
            max = Math.max(max, cut);
            dp[rem][N] = max;
            return max;
        }

        if(dp[rem][N] != -1) return dp[rem][N];


        dp[rem][N] = dp[rem][N-1] = maxCutsDP(rem,cuts,N-1,cut);
        if(rem -cuts[N-1]>=0){
            dp[rem-cuts[N-1]][N] = maxCutsDP(rem-cuts[N-1],cuts,N,cut+1);
            dp[rem][N] = Math.max(dp[rem-cuts[N-1]][N], dp[rem][N]);
        }
        return dp[rem][N];

    }



    //Utility
    static void evaluate(BiFunction<int[], Integer, Integer> func, int[] arr, int sum){
        recCalls =0;
        long start = System.nanoTime();
        System.out.println("Max Cuts "+func.apply(arr,sum));
        long end = System.nanoTime();
        System.out.println("Recursive Calls "+recCalls);
        System.out.println("Total Time "+ (end-start)/Math.pow(10, 6)+ "ms");

    }
}
