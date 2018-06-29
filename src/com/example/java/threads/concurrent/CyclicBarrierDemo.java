package com.example.java.threads.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3,()->{
            System.out.println("Barrier Action executed ");
        });


        CountTask task = new CountTask(50, barrier);
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
