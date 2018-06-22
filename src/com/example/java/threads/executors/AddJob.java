package com.example.java.threads.executors;

import java.util.concurrent.Callable;

public class AddJob implements Callable<Integer> {
    private int a ;
    private int b;
    private String jobName;
    public AddJob(int a, int b, String jobName) {
        this.a = a;
        this.b = b;
        this.jobName = jobName;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Worker : "+Thread.currentThread().getName());
        System.out.println(Thread.currentThread().hashCode() + " Hashcode");
        System.out.println("Running "+jobName);
        Thread.sleep(1000);
        return a+b;
    }
}
