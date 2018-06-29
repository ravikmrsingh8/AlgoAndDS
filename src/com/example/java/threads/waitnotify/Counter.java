package com.example.java.threads.waitnotify;

public class Counter {
    private int count;
    public synchronized void increment(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }
    public synchronized void decrement(){
        count--;
    }
}
