package com.example.design.observer;

public class Weather {
    private double temperature;
    private double humidity;
    private double windSpeed;

    public Weather(double temperature, double humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Temperature :" + getTemperature()).append("\n")
                .append("Wind Speed :" + getWindSpeed()).append("\n")
                .append("Humidity :" + getHumidity()).append("\n");
        return builder.toString();
    }
}
