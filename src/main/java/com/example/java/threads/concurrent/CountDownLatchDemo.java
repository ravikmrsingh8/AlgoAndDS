package com.example.java.threads.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        RunnableTask task = new RunnableTask(latch);
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All Threads Done");
    }
}
