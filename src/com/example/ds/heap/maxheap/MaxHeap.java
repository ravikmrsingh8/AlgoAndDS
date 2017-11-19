package com.example.ds.heap.maxheap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap {
    List<Integer> nodes = new ArrayList<>();

    public MaxHeap() {

    }

    public MaxHeap(int[] array) {
        for (int node : array) nodes.add(node);
        buildHeap();
    }

    private void buildHeap() {
        for (int i = parent(nodes.size() - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < nodes.size() && nodes.get(largest) < nodes.get(left)) largest = left;
        if (right < nodes.size() && nodes.get(largest) < nodes.get(right)) largest = right;
        if (largest != i) {
            Collections.swap(nodes, i, largest);
            heapify(largest);
        }
    }

    public Integer poll() {
        if (nodes.size() == 0) return null;
        int maxVal = nodes.get(0);
        nodes.set(0, nodes.get(nodes.size() - 1));
        nodes.remove(nodes.size() - 1);
        heapify(0);
        return maxVal;
    }

    void offer(int i) {
        nodes.add(i);
        percolateUp(nodes.size() - 1);
    }

    void percolateUp(int i) {
        int data = nodes.get(i);
        while (i > 0 && data > nodes.get(parent(i))) {
            nodes.set(i, nodes.get(parent(i)));
            i = parent(i);
        }
        nodes.set(i, data);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
