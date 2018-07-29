package com.example.java.threads.basic;

public class IncrementJob implements Runnable {
    private Counter counter;
    public IncrementJob(Counter counter){
        this.counter = counter;
    }
    public void run() {
        synchronized (counter){
            counter.increment();
            System.out.println(Thread.currentThread().getName() +", Counter "+counter.getCount());
        }
    }
}
