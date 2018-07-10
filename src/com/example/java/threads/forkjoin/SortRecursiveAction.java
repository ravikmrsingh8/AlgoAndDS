package com.example.java.threads.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class SortRecursiveAction extends RecursiveAction {

    private int[] arr;
    private int start;
    private int end;
    private final static int THRESHOLD = 1000000;
    public SortRecursiveAction(int[] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;

    }
    @Override
    protected void compute() {
        if(end - start <= THRESHOLD) {
            Arrays.sort(arr, start, end+1);
        } else {
            int mid = start + (end-start)/2;
            SortRecursiveAction a1 = new SortRecursiveAction(arr, start, mid);
            SortRecursiveAction a2 = new SortRecursiveAction(arr, mid+1, end);
            invokeAll(a1, a2);


            //Array is already sorted
            if(arr[mid] <= arr[mid+1]) return;


            //merge sorted array
            int[] arr1 = new int[mid - start + 1];
            int[] arr2 = new int[end - mid];
            System.arraycopy(arr, start, arr1, 0, mid - start + 1);
            System.arraycopy(arr, mid + 1, arr2, 0, end - mid);

            int i = 0;
            int j = 0;
            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    arr[start++] = arr1[i++];
                } else {
                    arr[start++] = arr2[j++];
                }
            }
            if (i < arr1.length) {
                System.arraycopy(arr1, i, arr, start, arr1.length - i);
            }

        }
    }
}
