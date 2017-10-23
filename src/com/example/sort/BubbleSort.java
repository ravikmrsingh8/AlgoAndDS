package com.example.sort;

public class BubbleSort implements Sorter {
    public void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utility.swap(arr, j, j + 1);
                }
            }
        }
    }
}
