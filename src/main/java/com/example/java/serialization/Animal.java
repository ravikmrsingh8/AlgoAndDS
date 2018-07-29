package com.example.java.serialization;

public class Animal {
    private double weight;
    public Animal(){
        System.out.println("Default Animal() called");
        weight = 10;
    }
    public Animal(double weight){
        System.out.println("Animal(weight) called");
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
