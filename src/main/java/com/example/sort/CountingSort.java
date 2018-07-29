package com.example.sort;

import static com.example.sort.Utility.printArray;

public class CountingSort  {
    public static void main(String[] args) {
        int[] A = {1,6,2,8,2,4,5,2,3,8,9,0,1,2,4,5,7,8,2,3};
        System.out.println("Array:");
        printArray(A);
        CountingSort sorter = new CountingSort();
        sorter.sort(A,10);
        System.out.println("Sorted Array:");
        printArray(A);
    }
    public void sort(int[] A, int MAX) {
        int N  = A.length;
        int[] C = new int[MAX];

        //get count of each element
        for(int i:A)C[i]++;

        //count array contains the count of elements <= index
        for(int i=1;i<MAX;i++) {
            C[i] += C[i-1];
        }

        int O[] = new int[N];

        //For each input element in Array A put it at it's sorted position
        //if say for a number n there are 10 element less or equal to n then we will put n  at index 9 ;
        //as indexing starts from 0
        for(int i=0;i<N;i++) {
            O[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
        System.arraycopy(O,0,A,0,N);
    }
}
