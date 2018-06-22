package com.example.java.collections.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet(Arrays.asList(1,2,3,4,5,4,2,1,3));
        System.out.println(set);
    }
}
