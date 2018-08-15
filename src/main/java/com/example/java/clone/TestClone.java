package com.example.java.clone;

public class TestClone {
    public static void main(String[] args) {
        Student ravi = new Student("Ravi", "Male", 30,1);
        Student clone =(Student) ravi.getClone();

        System.out.println(ravi + "HashCode"+ravi.hashCode());
        System.out.println(clone + "HashCode"+ clone.hashCode());
    }
}
