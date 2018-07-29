package com.example.problems.ps;

import java.util.Arrays;

import static com.example.sort.Utility.swap;

public class PutZeroesToRight {
    static int nonZeroIndex = 0;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        segregateZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void segregateZeroes(int[] arr){
        for(int i=0;i<arr.length; ){
            if(arr[i] != 0){
                i++;
            } else {
                if(nonZeroIndex == 0) nonZeroIndex = i+1;
                int index = findNextNonZeroIndex(arr);
                if(index == arr.length) return;
                else swap(arr, i, index);
                i++;
            }
        }
    }

    static int findNextNonZeroIndex(int[] arr){
        while(nonZeroIndex <arr.length && arr[nonZeroIndex] == 0) {
            nonZeroIndex++;
        }

        return nonZeroIndex;
    }
}
