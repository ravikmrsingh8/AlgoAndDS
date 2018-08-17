package com.example.ds.array;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0, 1, 2, 0, 0, 1, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int i = -1;
        int j = arr.length;

        int k = 0;
        while (k < j) {
            if (arr[k] == 0) {
                i += 1;
                swap(arr, i, k);
            } else if (arr[k] == 2) {
                j -= 1;
                swap(arr, j, k);
            } else {
                k++;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
