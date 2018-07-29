package com.example.ds.heap.maxheap;


public class TestMaxHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(new int[]{5, 8, 1, 5, 0, 3, 4, 7, 8, 9, 10});
        System.out.println("Test BuildHeap and Poll");
        for (int i = 0; i < 11; i++) {
            System.out.print(heap.poll() + "\t");
        }

        System.out.println("\nHeap offer and poll");
        heap = new MaxHeap();
        heap.offer(50);
        heap.offer(10);
        heap.offer(5);
        heap.offer(30);
        heap.offer(20);
        heap.offer(15);
        heap.offer(10);
        heap.offer(15);
        heap.offer(44);
        for (int i = 0; i < 9; i++) {
            System.out.print(heap.poll() + "\t");
        }
    }
}
