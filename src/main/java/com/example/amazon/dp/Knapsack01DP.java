package com.example.amazon.dp;


import java.util.Arrays;

public class Knapsack01DP {
    public static void main(String[] args) {
        int value = knapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50);
        System.out.println("Max Value :" + value);
        System.out.println("Recursive Calls :" + count);

        value = knapsack(new int[]{5, 4, 6, 3}, new int[]{10, 40, 30, 50}, 10);
        System.out.println("Max Value :" +value);
        System.out.println("Recursive Calls :" + count);
    }

    static int[][] maxVal;
    static int count = 0;
    static int knapsack(int[] wt, int[] val, int W){
        count =0;
        int N = wt.length;
        maxVal = new int[W+1][N+1];
        for(int[] values : maxVal){
            Arrays.fill(values, -1);
        }
        return knapsack(wt, val, W, N);
    }

    private static int knapsack(int[] wt, int[] val, int W, int N) {

        if(W <= 0 || N == 0) return 0;
        if(maxVal[W][N] != -1) return  maxVal[W][N];

        count++;
        if(wt[N-1] > W) {
            maxVal[W][N] = knapsack(wt, val, W, N-1);
        } else {
            int v1 = knapsack(wt, val, W, N-1);
            int v2 = knapsack(wt, val, W-wt[N-1], N-1) + val[N-1];
            maxVal[W][N] = Math.max(v1, v2);
        }
        return maxVal[W][N];
    }
}
