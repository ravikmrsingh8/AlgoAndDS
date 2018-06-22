package com.example.design.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Car car = new LuxuryCar(new SportsCar(new BasicCar()));
        car.assemble();
    }
}
