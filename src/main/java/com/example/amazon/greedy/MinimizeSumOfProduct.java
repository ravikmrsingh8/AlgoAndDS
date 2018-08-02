package com.example.amazon.greedy;

import java.util.Arrays;

/***
 * Given two arrays, A and B, of equal size n,
 * the task is to find the minimum value  of A[0] * B[0] + A[1] * B[1] +…+ A[n-1] * B[n-1],
 * where shuffling of elements of arrays A and B is allowed.
 * Examples:
 * Input : A[] = {3, 1, 1} and B[] = {6, 5, 4}.
 * Output : 23 Minimum value of S = 1*6 + 1*5 + 3*4 = 23.
 */
public class MinimizeSumOfProduct {
    public static void main(String[] args) {
        int A[] = {3, 1, 1};
        int B[] = {6, 5, 4};
        int productSum = minimizeProduct(A,B);
        System.out.println(productSum);
    }

    static int minimizeProduct(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;
        for(int i=0,j=A.length-1; i<A.length; i++,j--){
            result += A[i]*B[j];
        }
        return result;
    }
}
