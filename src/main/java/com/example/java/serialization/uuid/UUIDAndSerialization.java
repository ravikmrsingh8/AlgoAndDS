package com.example.java.serialization.uuid;

import java.io.*;

public class UUIDAndSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student(1, "Ravi");
        write(student);
        // Before reading change the serialVersionUUId of Student class
        // java.io.InvalidClassException: com.example.java.serialization.uuid.Student;
        // local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2

        Student student1 = read("student.ser");
        System.out.println(student1);
    }

    static Student read(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream oin = new ObjectInputStream(fin);
        Student student = (Student) oin.readObject();
        return student;
    }
    static String  write(Student student) throws IOException {
        String fileName = "student.ser";
        FileOutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(student);
        return fileName;
    }
}


