package com.example.ds.heap.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class OnlineMedian {
    Queue<Integer> minQ = new PriorityQueue<Integer>();
    Queue<Integer> maxQ = new PriorityQueue<Integer>(Comparator.reverseOrder());
    double median = Integer.MAX_VALUE;

    public double getMedian() {
        return median;
    }

    public double updateMedian() {
        if (minQ.size() > maxQ.size()) {
            return minQ.peek();
        } else if (minQ.size() < maxQ.size()) {
            return maxQ.peek();
        } else {
            return (minQ.peek() + maxQ.peek()) / 2.0;
        }
    }

    public void offer(int data) {
        if (data < median) {
            if (minQ.size() < maxQ.size()) {
                minQ.offer(maxQ.poll());
            }
            maxQ.offer(data);
        } else {
            if (minQ.size() > maxQ.size()) {
                maxQ.offer(minQ.poll());
            }
            minQ.offer(data);
        }
        median = updateMedian();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MinHeap " + minQ).append("\n");
        sb.append("MaxHeap" + maxQ);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OnlineMedian median = new OnlineMedian();
        while (true) {
            median.offer(in.nextInt());
            System.out.println("Median " + median.getMedian());
            System.out.println(median);
        }

    }
}
