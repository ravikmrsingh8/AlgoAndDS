package com.example.java.generics.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer>  q = new PriorityQueue<>();
        q.offer(null);
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q);


    }
}
