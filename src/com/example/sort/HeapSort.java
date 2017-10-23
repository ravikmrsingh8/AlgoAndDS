package com.example.sort;


import static com.example.sort.Utility.swap;

public class HeapSort implements Sorter {

    public void sort(int[] arr) {
        buildHeap(arr);
        int N = arr.length;
        while (N > 1) {
            swap(arr, 0, N - 1);
            N--;
            heapify(arr, N, 0);
        }
    }

    private void buildHeap(int[] arr) {
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    private void heapify(int[] arr, int N, int i) {
        int largest = i;
        int left = left(i);
        if (left < N && arr[left] > arr[largest]) {
            largest = left;
        }
        int right = right(i);
        if (right < N && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, N, largest);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
}
