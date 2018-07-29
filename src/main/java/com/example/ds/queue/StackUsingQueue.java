package com.example.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int data) {
        q1.offer(data);
    }

    Integer pop() {
        if (q1.isEmpty()) return null;
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int data = q1.poll();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return data;
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }
}
