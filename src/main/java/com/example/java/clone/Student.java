package com.example.java.clone;

public class Student extends Person  {

    private int studentId;
    public Student(String name, String sex, int age,int id) {
       super(name,sex,age);
       this.studentId = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * clone method has protected access in java.lang.Object so to call it on Student Object from main
     * we need to create a separate method in student class
     * @return Object
     */

    public Object getClone(){
        try {
            return clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Student["+"id="+ getStudentId() + ", name=" + getName() + ", sex=" + getSex() + ", age=" + getAge() + ']';
    }
}
