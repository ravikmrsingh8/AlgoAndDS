package com.example.java.threads.concurrent;

import java.util.concurrent.Exchanger;

public class LowercaseConverter implements Runnable {
    private Exchanger<String> exchanger;
    private String string;

    public LowercaseConverter(Exchanger<String> exchanger, String string) {
        this.exchanger = exchanger;
        this.string = string;
    }

    @Override
    public void run() {
        try {
            String str = exchanger.exchange(string.toLowerCase());
            System.out.println("Lowercase Converter Got " + str + " From Exchanger");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
