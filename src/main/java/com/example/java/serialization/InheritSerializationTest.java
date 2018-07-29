package com.example.java.serialization;

import java.io.*;

public class InheritSerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog = new Dog(52, "Black");


        System.out.println("Color :" + dog.getColor());
        System.out.println("Weight " + dog.getWeight());


        System.out.println("Serialization :");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream ob = new ObjectOutputStream(bos);
        ob.writeObject(dog);

        System.out.println("\nDeSerialization :");
        ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bin);
        Dog serDog = (Dog)in.readObject();


        System.out.println("Color :" + serDog.getColor());
        System.out.println("Weight " + serDog.getWeight());

    }
}
