package com.example.sort;

public class InsertionSort implements Sorter{
    public void sort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int data = arr[i];
            int j = i-1;
            while(j >=0 &&  data < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = data;
        }
    }
}
