package com.example.java.threads.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizationTest {
    public static void main(String[] args) {
        usingThreads(10);
        usingExecutors(10);
    }

    public static void usingThreads(int N){
        Counter counter = new Counter();
        IncrementJob job = new IncrementJob(counter);

        Thread[] threads = new Thread[N];
        for(int i=0;i< N;i++) {
            threads[i] = new Thread(job);
            threads[i].start();
        }
    }
    public static void usingExecutors(int N){
        Counter counter = new Counter();
        IncrementJob job = new IncrementJob(counter);

        ExecutorService service = Executors.newFixedThreadPool(N);
        for(int i=0;i< N;i++) {
            service.submit(job);
        }

        service.shutdown();
    }
}
