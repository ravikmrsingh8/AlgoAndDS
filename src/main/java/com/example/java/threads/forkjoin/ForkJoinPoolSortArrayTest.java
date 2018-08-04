package com.example.java.threads.forkjoin;

import com.example.sort.Utility;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolSortArrayTest {
    public static void main(String[] args) {
        int N = 100000000;
        int[] nums = Utility.getArray(N);
        int[] bk = new int[N];
        System.out.println("Array Populated");

        System.arraycopy(nums, 0, bk,0,N);



        forkjoin(nums,N);
        testSort(nums);

        arrysSort(bk, N);
        testSort(bk);



    }

    static void forkjoin(int[] nums, int N){
        SortRecursiveAction action = new SortRecursiveAction(nums, 0 , N-1);
        ForkJoinPool fjPool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        System.out.println("Starting fork Join: ");
        fjPool.invoke(action);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken to sort Array of Size "+ N + "is : "+  ((endTime-startTime)/1000.0)+" Sec");
        System.out.println("Task Done");

    }

    static void arrysSort(int[] nums,int N){
        System.out.println("Arrays.sort");
        long startTime = System.currentTimeMillis();
        Arrays.sort(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken to sort Array of Size "+ N + "is : "+  ((endTime-startTime)/1000.0)+" Sec");

    }

    static void testSort(int[] nums){
        System.out.println("Testing Array");
        System.out.print("Test :");
        System.out.println(Utility.testSort(nums)? "PASSED" : "FAILED");
    }
}
