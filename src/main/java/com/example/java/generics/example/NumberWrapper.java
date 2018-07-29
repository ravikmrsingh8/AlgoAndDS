package com.example.java.generics.example;

public class NumberWrapper<T extends Number> {
    private T t;
    public NumberWrapper(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    @Override
    public String toString() {
        return "[" + t +", " + t.getClass().getName() + "]";
    }
}
