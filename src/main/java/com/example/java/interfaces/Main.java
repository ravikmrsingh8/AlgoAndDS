package com.example.java.interfaces;

public class Main {
    public static void main(String[] args) {
        ITest test = new ITestImpl();
        test.sayHi();

        test = new SomeClass();
        test.sayHi();
    }
}
