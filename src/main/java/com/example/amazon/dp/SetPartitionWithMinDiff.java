package com.example.amazon.dp;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class SetPartitionWithMinDiff {

    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        int diff = partitionMinDiff(arr);
        System.out.println("Min diff : " + diff);


        int diffShivSai =  getDiff(0,4,arr,0,0);
        System.out.println("Min Diff :" + diffShivSai);
    }


    static int minDiff = Integer.MAX_VALUE;

    static int partitionMinDiff(int[] arr){
        int sum1 = 0;
        for(int e: arr)sum1+=e;
        partition(arr, sum1, 0, arr.length);
        return minDiff;
    }

    static void partition(int[] arr, int sum1, int sum2, int N) {

        if(N == 0) {
            minDiff = Math.min(Math.abs(sum1-sum2), minDiff);
            return;
        }

        partition(arr, sum1-arr[N-1], sum2+ arr[N-1], N-1);
        partition(arr, sum1, sum2, N-1);
    }


    static int getDiff(int i,int N, int[] arr, int sum1, int sum2){
        if(i==N) return Math.abs(sum1-sum2);
        return Math.min(getDiff(i+1, N, arr,sum1+arr[i], sum2), getDiff(i+1,N,arr, sum1, sum2+arr[i]));
    }


}
