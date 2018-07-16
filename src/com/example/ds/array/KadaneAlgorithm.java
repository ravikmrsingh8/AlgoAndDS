package com.example.ds.array;

/**
 * find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * for {-2, -3, 4, -1, -2, 1, 5, -3}; max sum is 7
 */
public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = kadane(arr);
        System.out.println("Max sum in an Array :" + maxSum);

        System.out.println("Max sum in an Array :" + kadaneExtended(arr));
        System.out.println("Max sum in an Array :" + kadaneExtended(new int[]{-1,-2,-3}));
    }

    static int kadane(int[] arr){
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum =0;
        }
        return maxSum;
    }

    static int kadaneExtended(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];

        for(int i=0;i<arr.length; i++) {
            sum = Math.max(arr[i], arr[i]+sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
