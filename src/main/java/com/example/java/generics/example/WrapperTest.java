package com.example.java.generics.example;


public class WrapperTest {
    public static void main(String[] args) {
        byte b = 1;
        NumberWrapper<Byte> byteWrapper = new NumberWrapper<>(b);
        NumberWrapper<Integer> integerWrapper = new NumberWrapper<>(1);
        NumberWrapper<Double> doubleWrapper = new NumberWrapper<>(2D);
        NumberWrapper<Float> floatWrapper = new NumberWrapper<>(1.2f);
        NumberWrapper<Long> longWrapper = new NumberWrapper<>(1L);

        System.out.println(byteWrapper);
        System.out.println(integerWrapper);
        System.out.println(doubleWrapper);
        System.out.println(floatWrapper);
        System.out.println(longWrapper);


    }
}
