package com.example.java.serialization;

import java.io.Serializable;

public class Dog extends Animal implements Serializable {
    private String color;

    public Dog(String color) {
        System.out.println("Dog(color) called");
        this.color = color;
    }

    public Dog(double weight, String color) {
        super(weight);
        System.out.println("Dog(weight, color) called");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
