package com.example.java.threads.forkjoin;

import com.example.sort.Utility;


import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolSortArrayTest {
    public static void main(String[] args) {
        int N = 100000000;
        int[] nums = Utility.getArray(N);
        System.out.println("Array Populated");

        SortRecursiveAction action = new SortRecursiveAction(nums, 0 , nums.length-1);
        ForkJoinPool fjPool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        System.out.println("Starting fork Join: ");
        fjPool.invoke(action);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken to sort Array of Size "+ N + "is : "+  ((endTime-startTime)/1000.0)+" Sec");
        System.out.println("Task Done");

        System.out.println("Testing Array");
        System.out.print("Test :");
        System.out.println(Utility.testSort(nums)? "PASSED" : "FAILED");
        //System.out.println(Arrays.toString(nums));
        //Takes 3.3 sec average to sort 100 million size array




        /*
        long startTime = System.currentTimeMillis();
        Arrays.sort(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken to sort Array of Size "+ N + "is : "+  ((endTime-startTime)/1000.0)+" Sec");
        //Takes average of 4.3 sec to sort array of size 100 million
        */
    }
}
