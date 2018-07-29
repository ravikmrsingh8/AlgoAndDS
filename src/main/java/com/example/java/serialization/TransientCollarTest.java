package com.example.java.serialization;

import java.io.*;

public class TransientCollarTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat cat =new Cat("Kitty", true);
        //cat.setCollar(new Collar(3));
        cat.setCollar(new Collar(3));

        System.out.println("Original " + cat);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(cat);
        byte[] buf = bos.toByteArray();

        ByteArrayInputStream bin = new ByteArrayInputStream(buf);
        ObjectInputStream in = new ObjectInputStream(bin);
        Cat serCat = (Cat)in.readObject();
        System.out.println("Serialized " +serCat);

    }
}
