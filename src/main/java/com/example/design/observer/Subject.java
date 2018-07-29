package com.example.design.observer;

import java.util.HashSet;
import java.util.Set;

public class Subject {
    private String loc;

    private Weather weather;
    private Weather oldWeather;

    private boolean changed = false;

    private Set<Observer> observers = new HashSet<>();

    public Subject(String loc) {
        this.loc = loc;

        //Default weather
        oldWeather = new Weather(0.0,0,0);
        weather = new Weather(0.0,0,0);
    }

    private Set<Observer> getObservers() {
        return observers;
    }


    public void addObserver(Observer ob) {
        if (ob == null) throw new NullPointerException("Observer can not be null");
        getObservers().add(ob);

    }

    public Observer removeObserver(Observer ob) {
        observers.remove(ob);
        return ob;
    }

    public void notifyObservers() {
        if (!hasChanged()) return;
        for (Observer ob : getObservers()) {
            ob.update(getData());
        }
        clearChanged();
    }

    public void setWeather(Weather weather) {
        this.oldWeather = getWeather();
        this.weather = weather;
        if (getDelta(this.weather, this.oldWeather) >= 1) setChanged();
        notifyObservers();
    }

    public Weather getWeather() {
        return weather;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    public boolean hasChanged() {
        return changed;
    }

    public void setChanged() {
        this.changed = true;
    }

    public void clearChanged() {
        this.changed = false;
    }

    double getDelta(Weather newInfo, Weather oldInfo) {

        return (int) (Math.abs(newInfo.getTemperature() - oldInfo.getTemperature()))
                + (int) (Math.abs(newInfo.getHumidity() - oldInfo.getHumidity()))
                + (int) Math.abs(newInfo.getWindSpeed() - oldInfo.getWindSpeed());
    }

    Weather getData() {
        return getWeather();
    }
}
