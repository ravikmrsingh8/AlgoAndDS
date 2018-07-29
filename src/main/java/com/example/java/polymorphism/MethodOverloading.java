package com.example.java.polymorphism;

import java.util.Collection;
import java.util.HashSet;

public class MethodOverloading {
    public static void main(String[] args) {
        Collection<String> c = new HashSet<String>();
        call(c);
    }
    static void call(Collection<String> c){
        System.out.println("Called With Collection Parameter");
    }
    static void call(HashSet<String> set){
        System.out.println("Called With HashSet Parameter");
    }
}
