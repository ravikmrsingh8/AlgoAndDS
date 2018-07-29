package com.example.java.threads.executors;

public class PrintJob implements Runnable {
    private String jobName;

    public PrintJob(String jobName){
        this.jobName = jobName;
    }
    public void run(){
        System.out.println("Worker :"+Thread.currentThread().getName() );
        System.out.println("Running " + jobName);
    }
}
