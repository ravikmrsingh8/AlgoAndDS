package com.example.java.generics.collections;

import com.example.java.generics.Animal;
import com.example.java.generics.Dog;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<? super Dog> animals = new ArrayList<Dog>();
        animals.add(new Dog());
        //animals.add(new Cat());  // Not Allowed

        List<? extends Animal> animals1 = new ArrayList<Animal>();
        List<? super Dog> animals2 = new ArrayList<Animal>();


    }



}
