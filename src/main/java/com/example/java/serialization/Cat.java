package com.example.java.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private boolean fur;
    private transient Collar collar;


    public Cat() {
        System.out.println("Default Cat Constructor");
    }

    public Cat(String name, boolean fur) {
        System.out.println("Cat Constructor(name, fur)");
        this.name = name;
        this.fur = fur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasFur() {
        return fur;
    }

    public void setFur(boolean fur) {
        this.fur = fur;
    }

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        if(getCollar() != null) {
            out.writeInt(getCollar().getSize());
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if(in.available() > 0) {
            setCollar(new Collar(in.readInt()));
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cat [");
        sb.append(getName()+"," + hasFur()+ "," + getCollar()).append("]");
        return sb.toString();
    }
}
