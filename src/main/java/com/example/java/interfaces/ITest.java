package com.example.java.interfaces;

public interface ITest {
    default void sayHi(){
        System.out.println("Hi");
    }
}
