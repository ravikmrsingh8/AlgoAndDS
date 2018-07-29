package com.example.java.serialization;

public class Collar {
    private int size;

    public Collar(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new StringBuilder("Collar [")
                .append(getSize()).append("]").toString();
    }
}
