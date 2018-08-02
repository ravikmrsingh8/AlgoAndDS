package com.example.amazon.dp;

import java.util.Arrays;
import java.util.function.Function;

/***
 * Minimum Operations
 * Given a number N the task is to find an optimal solution to reach N from 0 using 2 operations ie
 * 1. Double the number
 * 2. Add one to the number
 *
 * Input  7
 * Output : 5
 * 1->0 + 1 = 1,
 * 2->1 + 1 = 2,
 * 3->1 + 2 = 3,
 * 4->3 * 2 = 6,
 * 5->6 + 1 = 7
 */
public class MinimumOperations {
    static int count =0;
    public static void main(String[] args) {
        int N = 400;
        System.out.println("Evaluate Recursive Approach");
        evaluate(MinimumOperations::findOpsRec, N);

        System.out.println("\nEvaluate DP Memoization Approach");
        evaluate(MinimumOperations::findOpsDPMemo, N);

        System.out.println("\nEvaluate DP Tabulation Approach");
        evaluate(MinimumOperations::findOpsTab, N);
    }

    static int findOpsRec(int N){
        count++;
        if(N == 0) return 0;
        if(N == 1) return 1;

        if(N%2==0){
            return Math.min(findOpsRec(N/2), findOpsRec(N-1)) + 1;
        } else {
            return Math.min(findOpsRec(N/2) + 1, findOpsRec(N-1)) + 1;
        }
    }

    static int findOpsDPMemo(int N){
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        return findOps(N, dp);
    }

    static int findOpsTab(int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = Math.min(dp[i/2]+i%2 , dp[i-1]) + 1;
        }
        return dp[N];
    }
    static int findOps(int N, int[] dp){
        count++;
        if(dp[N] != -1) return dp[N];
        if(N == 0) return dp[0] = 0;
        if(N == 1) return dp[1] = 1;
        dp[N/2] = findOps(N/2, dp);
        dp[N-1] = findOps(N-1, dp);
        return Math.min(dp[N/2] + N%2, dp[N-1]) + 1;
    }


    static void evaluate(Function<Integer, Integer> function, int N){
        count = 0;
        long start = System.nanoTime();
        System.out.println("Min Operation: "+function.apply(N));
        System.out.println("Recursive Calls :"+ count);
        long end = System.nanoTime();
        System.out.println((end-start)/1000.0 + "ms");
    }

}
