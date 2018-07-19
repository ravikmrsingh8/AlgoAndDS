package com.example.java.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class BiConsumerTest {
    Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
    BiConsumerTest(){
        map.put("+", (a,b)->a+b);
        map.put("-", (a,b)->a-b);
        map.put("*", (a,b)->a*b);
        map.put("/", (a,b)->a/b);
    }


    public static void main(String[] args) {
        BiConsumerTest test = new BiConsumerTest();

        System.out.println(test.map.get("+").apply(1,3));
        System.out.println(test.map.get("-").apply(1,3));
        System.out.println(test.map.get("/").apply(1,3));
        System.out.println(test.map.get("*").apply(1,3));
    }

}
