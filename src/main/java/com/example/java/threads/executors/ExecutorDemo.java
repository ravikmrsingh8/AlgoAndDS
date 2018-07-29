package com.example.java.threads.executors;

import java.util.concurrent.*;
import java.util.function.BiConsumer;

public class ExecutorDemo {
    public static void main(String[] args) throws  Exception{
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new PrintJob("Job1"));
        service.execute(new PrintJob("Job2"));
        service.execute(new PrintJob("Job3"));
        service.execute(new PrintJob("Job4"));
        service.execute(new PrintJob("Job5"));
        service.execute(new PrintJob("Job6"));
        service.execute(new PrintJob("Job7"));


        Future<?> future =  service.submit(new PrintJob("job8"));
        Thread.sleep(1000);
        System.out.println("Job is Done :" + future.isDone());

        Future<Integer> addRes = service.submit(new AddJob(1,2, "AddJob1"));
        System.out.println("Result of Add 1,2 =" + addRes.get());

        Future<Integer> addRes3 = service.submit(new AddJob(3,4, "Job3"));
        try {
            addRes3.get(100, TimeUnit.MILLISECONDS);
        }catch (TimeoutException e) {
            System.out.println("Timeout Occurs");
        }

        System.out.println("Result of Job3: " + addRes3.get());




        service.shutdown();

        //service.execute(new PrintJob());

        methRef(ExecutorDemo::accept, 1, 2);



        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(2);
        service2.schedule(new PrintJob("Job0" ),4000, TimeUnit.MILLISECONDS);
        service2.scheduleAtFixedRate(new PrintJob("Job00"), 1000, 1000, TimeUnit.MILLISECONDS);

    }

    public static  void accept(int a, int b){
        System.out.println("A:" +a);
        System.out.println("B:" +b);

    }
    public static void methRef(BiConsumer<Integer, Integer> biConsumer , Integer a, Integer b) {
        biConsumer.accept(a,b);
    }
}
