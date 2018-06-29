package com.example.java.threads.basic;

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
