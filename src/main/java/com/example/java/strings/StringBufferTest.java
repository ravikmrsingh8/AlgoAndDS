package com.example.java.strings;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        System.out.println(s.capacity());

        s.append("abcd");
        s.append("abcd");
        s.append("abcd");
        s.append("abcd");
        System.out.println(s.capacity());
        s.append("abcd");
        s.append("abcd");
        s.append("abcd");
        s.append("abcd");

        System.out.println(s.capacity());
        s.append("abcd");
        System.out.println(s.capacity());


    }
}
