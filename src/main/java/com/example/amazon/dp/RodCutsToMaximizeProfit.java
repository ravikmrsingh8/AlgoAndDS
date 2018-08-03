package com.example.amazon.dp;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 *
 * Algorithm
 * 1) if Length is 0 return profit obtained is 0
 * 2) find the price by cutting the rod at length 1,2,3,4,..N-1 recursively
 * i.e in each call if we have rod of length N prices can be obtained by
 *   P[i] + cut(P, N-i-1) for all i 0 to N-1;
 *
 *
 *   find the max of (P[i] + maxProfit(P,N-i-1)) for all i , 0<=i<N;
 */
public class RodCutsToMaximizeProfit {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20,22,34,40,42,44};
        System.out.println("Recursive");
        evaluate(RodCutsToMaximizeProfit::maxProfit, price, price.length);

        System.out.println("Tabulation");
        evaluate(RodCutsToMaximizeProfit::maxProfitTab, price, price.length);

        System.out.println("Memoization");
        evaluate(RodCutsToMaximizeProfit::maxProfitMemo, price, price.length);
    }

    static int maxProfit(int[] price, int L){
        recCalls++;
        if(L == 0) return 0;
        int maxPrice = Integer.MIN_VALUE;
        for(int i=0;i<L;i++){
            maxPrice = Math.max(maxPrice, price[i] + maxProfit(price, L-1-i));
        }
        return maxPrice;
    }

    static int maxProfitTab(int[] price,int L){
        int[] dp = new int[L+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = price[0];

        for(int i=2;i<=L;i++){
            for(int j=0; j<i;j++){
                dp[i] = Math.max(dp[i], price[j]+ dp[i-j-1]);
            }
        }
        return dp[L];
    }

    static int[] dp;
    static int maxProfitMemo(int[] price, int L){
        dp = new int[L+1];
        Arrays.fill(dp, -1);
        return maxProfitMemo0(price,L);
    }

    private static int maxProfitMemo0(int[] price, int L) {
        recCalls++;

        if(L == 0) return 0;
        if(dp[L] != -1) return dp[L];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<L;i++) {
            dp[L-i-1] = maxProfitMemo0(price, L-i-1);
            max = Math.max(price[i] + dp[L-i-1], max);
        }
        dp[L] = max;
        return dp[L];
    }


    //Utility
    static int recCalls =0;
    static void evaluate(BiFunction<int[], Integer, Integer> func,  int[] price, int N){
        recCalls =0;
        long start = System.nanoTime();
        System.out.println("Max Price "+func.apply(price, N));
        long end = System.nanoTime();
        System.out.println("Recursive Calls "+recCalls);
        System.out.println("Total Time "+ (end-start)/Math.pow(10, 6)+ "ms");

    }
}
