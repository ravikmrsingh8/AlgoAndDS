package com.example.java.clone;

public class Student implements Cloneable {
    private String name;
    private String sex;
    private int age;

    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    /**
     * clone method has protected access in java.lang.Object so to call it on Student Object from main we need to override it
     * @return Object
     */
    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Student[" + "name=" + name + ", sex=" + sex + ", age=" + age + ']';
    }
}
