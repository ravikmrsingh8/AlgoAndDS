package com.example.sort;

public class MergeSort implements Sorter {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] arr1 = new int[m - l + 1];
        int[] arr2 = new int[r - m];
        System.arraycopy(arr, l, arr1, 0, m - l + 1);
        System.arraycopy(arr, m + 1, arr2, 0, r - m);

        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[l++] = arr1[i++];
            } else {
                arr[l++] = arr2[j++];
            }
        }
        if (i < arr1.length) {
            System.arraycopy(arr1, i, arr, l, arr1.length - i);
        }
    }
}
