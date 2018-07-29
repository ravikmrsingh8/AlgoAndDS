package com.example.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMethods {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,6,7,8));


        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);

        System.out.println(list);
    }
}
