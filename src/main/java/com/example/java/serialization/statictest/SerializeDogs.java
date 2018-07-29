package com.example.java.serialization.statictest;

import java.io.*;

public class SerializeDogs {
    public static void main(String[] args) throws IOException {
        Dog dog1 = new Dog("Fikki", 20);
        System.out.println(dog1);
        serialize("dog1", dog1);

        Dog dog2 = new Dog("Jacky", 19);
        System.out.println(dog2);
        serialize("dog2", dog2);

        Dog dog3 = new Dog("Funtu", 18);
        System.out.println(dog3);
        serialize("dog3", dog3);

        System.out.println("Done!");
    }

    static void serialize(String fileName, Dog dog) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName);
        ObjectOutputStream ob = new ObjectOutputStream(out);
        ob.writeObject(dog);
    }


}
