package com.example.design.observer;

public class ChicagoTemperatureDisplay implements Observer {

    @Override
    public void update(Weather weatherInfo) {
        System.out.println("Chicago weather\n" + weatherInfo);
    }
}
