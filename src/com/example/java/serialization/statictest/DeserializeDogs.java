package com.example.java.serialization.statictest;

import java.io.*;

public class DeserializeDogs {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog1 = deserialize("dog1");
        System.out.println(dog1);

        Dog dog2 = deserialize("dog2");
        System.out.println(dog2);

        Dog dog3 = deserialize("dog3");
        System.out.println(dog3);

    }

    static Dog deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream inOb = new ObjectInputStream(fin);
        return (Dog)inOb.readObject();
    }
}
