package com.example.java.generics.example;

import com.example.java.generics.Cat;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    public static void main(String[] args) {
        List<Cat> cats = getArrayList(new Cat[]{new Cat(),new Cat(),new Cat(),new Cat(),new Cat()});
        System.out.println(cats);


        List<Integer> ints = getArrayList(new Integer[]{ 1,2, 3,4});
        System.out.println(ints);

    }


    public static <T> List<T> getArrayList(T[] ts) {
        List<T> list = new ArrayList<T>();
        for(T t :ts )list.add(t);
        return list;
    }

}
