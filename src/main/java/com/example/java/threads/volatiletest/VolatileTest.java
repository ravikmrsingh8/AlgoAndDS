package com.example.java.threads.volatiletest;

public class VolatileTest {
    static class Counter{
        volatile int counter =0;
        synchronized void increment(){this.counter++;}
        synchronized void decrement(){this.counter--;}
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new  VolatileTest.Counter();
        while(true) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }).start();

            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    counter.decrement();
                }
            }).start();

            Thread.sleep(1000);
            System.out.println(counter.counter);
        }
    }
}
