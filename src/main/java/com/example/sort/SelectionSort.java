package com.example.sort;


public class SelectionSort implements Sorter {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int mIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[mIndex]) mIndex = j;
            }
            if (mIndex != i) Utility.swap(arr, i, mIndex);
        }
    }

}
