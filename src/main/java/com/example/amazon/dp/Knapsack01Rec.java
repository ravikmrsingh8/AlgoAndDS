package com.example.amazon.dp;

public class Knapsack01Rec {
    public static void main(String[] args) {

        int value = knapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50);
        System.out.println("Max Value :" + value);
        System.out.println("Recursive Calls :" + count);

        value = knapsack(new int[]{5, 4, 6, 3}, new int[]{10, 40, 30, 50}, 10);
        System.out.println("Max Value :" +value);
        System.out.println("Recursive Calls :" + count);
    }

    static int count =0;
    static int knapsack(int[] wt, int[] val, int W) {
        count =0;
        return knapsack(wt, val, W, wt.length);
    }

    private static int knapsack(int[] wt, int[] val, int W, int N) {

        if(N == 0 || W <= 0) return 0;
        count++;
        if(wt[N-1] > W) {
            return knapsack(wt, val, W, N-1);
        } else {
            int value1 = knapsack(wt, val, W, N-1);
            int value2 = knapsack(wt, val, W-wt[N-1], N-1) + val[N-1];
            return Math.max(value1, value2);
        }
    }
}
