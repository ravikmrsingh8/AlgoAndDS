package com.example.problems.ps;

public class MaxDiffInAnArray {
    public static void main(String[] args) {
        System.out.println("Max Diff:" + findMaxDiff(new int[]{7, 9, 5, 6, 3, 2}));
        System.out.println("Max Diff:" + findMaxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));

    }
    static int findMaxDiff(int[] arr) {
        int min = arr[0];
        int maxDiff = Integer.MIN_VALUE;

        for(int i=1;i<arr.length; i++) {
            maxDiff = Math.max(maxDiff, arr[i]-min);
            if(arr[i]<min)min = arr[i];
        }
        return maxDiff;
    }
}
