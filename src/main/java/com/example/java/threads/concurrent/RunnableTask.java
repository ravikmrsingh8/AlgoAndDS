package com.example.java.threads.concurrent;

import java.util.concurrent.CountDownLatch;

public class RunnableTask implements Runnable {
    private CountDownLatch latch;
    public RunnableTask(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Running..");
        latch.countDown();
    }
}
