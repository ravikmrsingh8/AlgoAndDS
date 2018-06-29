package com.example.java.serialization.statictest;

import java.io.Serializable;

public class Dog implements Serializable {
    private static int count = 0;
    private int age;
    private String name;
    public Dog(String name, int age){
        this.name= name;
        this.age = age;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Dog.count = count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dog [");
        sb.append(name).append(",").append(age).append(",Count" + count);
        sb.append("]");
        return sb.toString();
    }
}
