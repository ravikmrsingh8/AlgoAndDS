package com.example.ds.array;

import java.util.Arrays;

/**
 *
 * Rotate Matrix by 90 deg
 * By using extra space
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        printMatrix(mat);
        System.out.println();
        int[][] m = rotateMatrix(mat, 3, 4);
        printMatrix(m);
    }

    static int[][] rotateMatrix(int[][] arr, int M, int N){
        int[][] dest =  new int[N][M];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                dest[j][M-i-1] = arr[i][j];
            }
        }
        return dest;
    }
    static void printMatrix(int[][] m){
        for(int[] arr: m){
            System.out.println(Arrays.toString(arr));
        }
    }
}
