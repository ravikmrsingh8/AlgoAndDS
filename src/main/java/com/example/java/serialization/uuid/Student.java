package com.example.java.serialization.uuid;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 2L;
    private int id;
    private String name;

    public Student() {
        System.out.println("Student()");
    }

    public Student(int id, String name){
        this.id = id;
        this.name = name;
        System.out.println("Student("+id+","+name+")");
    }

    public int getId() {
        System.out.println("getId()");
        return id;
    }

    public void setId(int id) {
        System.out.println("setId("+id+")");
        this.id = id;
    }

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName("+name+")");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student[" + "id=" + id + ", name=" + name  +"]";
    }
}
