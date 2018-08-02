package com.example.amazon.dp;

import java.util.function.Function;

/**
 *
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is same.
 *
 * Input arr[] = {1, 5, 11, 5}
 * Output: true
 * partitions are {1, 5, 5} and {11}
 *
 * arr[] = {1, 5, 3, 2}
 * Output: false
 *
 * arr[] = {1, 5, 3}
 * Output: false
 *
 * Algorithm:-
 * 1) find sum of all elements
 * 2) if sum is odd return false
 * 3) find if subset exist with sum as sum/2
 */
public class SetPartition {
    public static void main(String[] args) {
        int[] arr1 = {1,5,11,5};
        int[] arr2 = {1,5,3};
        int[] arr3 = {1,5,3,2};
        evaluate(SetPartition::canBePartitioned, arr1);
        evaluate(SetPartition::canBePartitioned, arr2);
        evaluate(SetPartition::canBePartitioned, arr3);
    }

    static boolean canBePartitioned(int[] arr){
        int sum = 0;
        for(int e: arr)sum+=e;
        if(sum%2 != 0) return false;
        return subSetFound(sum/2, arr.length, arr);
    }

    static boolean subSetFound(int sum, int N, int[] arr){
        boolean[][] dp = new boolean[sum+1][N+1];
        for(int i=1;i<=sum;i++)dp[i][0]=false;
        for(int j=0;j<=N;j++)dp[0][j] = true;
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=N;j++){
                boolean found = i-arr[j-1]>=0?dp[i-arr[j-1]][j-1]:false;
                dp[i][j] = dp[i][j-1] || found;
            }
        }

        return dp[sum][N];

    }
    static void evaluate(Function<int[], Boolean> func, int[] arr){
        System.out.println();
        long start = System.nanoTime();
        System.out.println(func.apply(arr));
        long end = System.nanoTime();
        System.out.println("Time taken :" + (end-start)/1000.0 + " ms.");
    }
}
