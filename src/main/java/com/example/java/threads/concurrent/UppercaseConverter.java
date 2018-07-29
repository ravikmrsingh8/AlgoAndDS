package com.example.java.threads.concurrent;

import java.util.concurrent.Exchanger;

public class UppercaseConverter implements Runnable {
    private Exchanger<String> exchanger;
    private String string;

    public UppercaseConverter(Exchanger<String> exchanger, String string) {
        this.exchanger = exchanger;
        this.string = string;
    }

    @Override
    public void run() {
        try {
            String str = exchanger.exchange(string.toUpperCase());
            System.out.println("Uppercase Converter Got " + str + " From Exchanger");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
