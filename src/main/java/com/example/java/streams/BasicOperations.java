package com.example.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * from a list of numbers filter even numbers then divide them by 2 and get all filtered numbers in a list;
 */
public class BasicOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(list);
        List<Integer> newList = list.stream().filter(e->e%2==0).map(e->e/2).collect(Collectors.toList());
        System.out.println(newList);
        System.out.println(list);


        int value = list.stream().reduce((e1, e2)-> e1+e2).get();
        System.out.println(value);
    }
}
