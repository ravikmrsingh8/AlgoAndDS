package com.example.java.threads.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new LowercaseConverter(exchanger, "Hello")).start();
        new Thread(new UppercaseConverter(exchanger, "Hi")).start();

        new Thread(new LowercaseConverter(exchanger, "Aloha")).start();
        new Thread(new UppercaseConverter(exchanger, "Hola")).start();


    }
}
