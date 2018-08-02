package com.example.amazon.dp;


/**
 * Given an array of non-negative integers and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 * Examples:
 * Input : arr[] = {4, 1, 10, 12, 5, 2} and sum = 9
 * Output : TRUE
 */
public class SubsetSum {
    public static void main(String[] args) {
        int sum = 335;
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,3,31,32,33,34,35};
        evaluate(SubsetSum::sumPossible, arr, sum, arr.length);
        evaluate(SubsetSum::sumPossibleDP, arr, sum, arr.length);
    }

    static boolean sumPossible(int[] arr, int sum, int N){
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(N ==0) return false;
        return sumPossible(arr, sum, N-1) || sumPossible(arr,sum-arr[N-1], N-1);

    }


    static boolean sumPossibleDP(int[] arr, int sum, int N ){
        boolean[][] dp = new boolean[sum+1][N+1];
        for(int i=1;i<=sum;i++)dp[i][0] = false;
        for(int j=0;j<=N;j++)dp[0][j] = true;

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=N;j++){
                boolean choose = i-arr[j-1]>=0?dp[i-arr[j-1]][j-1]:false;
                dp[i][j] = dp[i][j-1]  || choose;
            }
        }
        return dp[sum][N];
    }

    static void evaluate(Function function,int[] arr, int sum, int N){
        System.out.println();
        long start = System.nanoTime();
        System.out.println(function.apply(arr, sum, N));
        long end = System.nanoTime();
        System.out.println((end-start)/1000.0 + "ms");
    }

    interface Function{
        boolean apply(int[] arr, int sum, int N);
    }
}
