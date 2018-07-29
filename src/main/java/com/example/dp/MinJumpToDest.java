package com.example.dp;

import java.util.Arrays;

public class MinJumpToDest {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(findMinJump(arr));

    }

    static int findMinJump(int[] arr){
        int[] jumps= new int[arr.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;


        for(int i=0;i<arr.length;i++) {
            for(int j=i+1; j<= i+arr[i] && j< arr.length;j++) {
                if(jumps[i] + 1 < jumps[j])jumps[j] =jumps[i] + 1;
            }
        }
        System.out.println(Arrays.toString(jumps));
        return jumps[arr.length-1];
    }
}
