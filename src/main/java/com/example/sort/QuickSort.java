package com.example.sort;

import static com.example.sort.Utility.swap;

class QuickSort implements Sorter {
    private int partition(int arr[], int l, int h) {
        int p = arr[h];
        int i = l-1;
        for(int j = l; j<h; j++){
            if(arr[j] < p) {
                i= i+1;
                Utility.swap(arr, i,j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }

    private void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

}