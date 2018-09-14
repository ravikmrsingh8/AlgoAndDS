package com.example.java.lambda.capture;

public class VariableCaptureDemo {
    int memVar = 9;
    public static void main(String[] args) {
        final int abcd = 4;

        VariableCaptureDemo demo = new VariableCaptureDemo();

        Calculator calc = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                System.out.println("abcd:" + abcd);
                demo.memVar += 1;
                System.out.println(this);
                return a+ b;
            }
        };

        System.out.println(calc.calculate(4,5));
        System.out.println("Memvar: " + demo.memVar);
        System.out.println(calc.calculate(9,10));
    }
}
