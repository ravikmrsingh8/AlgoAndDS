package com.example.java.threads.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountTask implements  Runnable {

    private CyclicBarrier barrier;
    private int N;
    public CountTask(int N, CyclicBarrier barrier){
        this.barrier = barrier;
        this.N = N;
    }

    @Override
    public void run() {
        for(int i=0;i<N;i++) {
            if(i == N/2) {
                System.out.println(Thread.currentThread().getName() + "Reached at Half Count");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
