package com.example.java.threads.waitnotify;

import com.example.java.threads.basic.Counter;

public class WaitNotifyTest {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();

        new Thread(()->{
            synchronized (counter){
                try {
                    System.out.println(Thread.currentThread().getName() + "Waiting");
                    counter.wait();
                    System.out.println(Thread.currentThread().getName() + "Got Count "+ counter.getCount());
                    //counter.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            synchronized (counter){
                try {
                    System.out.println(Thread.currentThread().getName() + "Waiting");
                    counter.wait();
                    System.out.println(Thread.currentThread().getName() + "Got Count "+ counter.getCount());
                    //counter.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(()->{
            synchronized (counter){
                try {
                    System.out.println(Thread.currentThread().getName() + "Waiting");
                    counter.wait();
                    System.out.println(Thread.currentThread().getName() + "Got Count "+ counter.getCount());
                    //counter.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        Thread.sleep(1000);

        new Thread(()->{
            synchronized (counter){
                for(int i=0;i<100;i++){
                    counter.increment();
                }
                counter.notifyAll();
            }
        }).start();



    }
}
