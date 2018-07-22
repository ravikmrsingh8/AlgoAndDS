package com.example.java.strings;

import java.util.Arrays;

public class NullCharacter {
    public static void main(String[] args) {
        char[] string = {'\0','\0'};
        System.out.println(Arrays.toString(string));
        System.out.println(new String(string));
    }
}
