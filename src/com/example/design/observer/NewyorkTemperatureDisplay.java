package com.example.design.observer;

public class NewyorkTemperatureDisplay implements Observer {
    @Override
    public void update(Weather weatherInfo) {
        System.out.println("Newyork Weather :\n" +weatherInfo);
    }
}
