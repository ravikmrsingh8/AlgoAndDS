package com.example.design.observer;

public class Main {
    public static void main(String[] args) {
        Subject subject1 = new ChicagoWeatherStattion();
        Subject subject2 = new NewyorkWeatherStation();

        Observer chicagoWeatherDisplay = new ChicagoTemperatureDisplay();
        Observer newyorkWeatherDisplay = new NewyorkTemperatureDisplay();
        subject1.addObserver(chicagoWeatherDisplay);
        subject2.addObserver(newyorkWeatherDisplay);


        subject1.setWeather(new Weather(20,2,2));
        subject1.setWeather(new Weather(20,2.2,2.3));
        subject1.setWeather(new Weather(30,4,2));
        subject1.setWeather(new Weather(31,2.2,2.3));

        subject2.setWeather(new Weather(30,2,2));
        subject2.setWeather(new Weather(30.2,2.2,2.3));
        subject2.setWeather(new Weather(30,4,2));
        subject2.setWeather(new Weather(32,2.2,2.3));
    }
}
