package com.example.ds.heap.minheap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap {
    private List<Integer> nodes;

    public MinHeap(int[] array) {
        nodes = new ArrayList<>();
        for (int i : array) nodes.add(i);
        buildHeap();
    }

    public MinHeap() {
        nodes = new ArrayList<>();
    }

    private void buildHeap() {
        for (int i = parent(nodes.size() - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if (left < nodes.size() && nodes.get(left) < nodes.get(smallest)) smallest = left;
        if (right < nodes.size() && nodes.get(right) < nodes.get(smallest)) smallest = right;
        if (smallest != i) {
            Collections.swap(nodes, smallest,i);
            heapify(smallest);
        }
    }
    public Integer poll(){
        if(nodes.size() == 0) return null;
        int minElement = nodes.get(0);
        Collections.swap(nodes, 0, nodes.size()-1);
        nodes.remove(nodes.size()-1);
        heapify(0);
        return minElement;
    }

    public void offer(int data){
        nodes.add(data);
        percolateUp(nodes.size()-1);
        //System.out.println(nodes);
    }

    private void percolateUp(int i){
        int data = nodes.get(i);
        while(i > 0 && data < nodes.get(parent(i))) {
            nodes.set(i,nodes.get(parent(i)));
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
