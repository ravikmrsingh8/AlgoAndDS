package com.example.java.threads.forkjoin;

import com.example.sort.Utility;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolSortArrayTest {
    public static void main(String[] args) {
        int[] nums = Utility.getArray(100000000);
        System.out.println("Array Populated");

        SortRecursiveAction action = new SortRecursiveAction(nums, 0 , nums.length-1);
        ForkJoinPool fjPool = new ForkJoinPool();
        System.out.println("Starting fork Join");
        fjPool.invoke(action);
        System.out.println("Task Done");

        System.out.println("Testing Array");
        System.out.print("Test :");
        System.out.println(Utility.testSort(nums)? "PASSED" : "FAILED");
        //System.out.println(Arrays.toString(nums));
    }
}
