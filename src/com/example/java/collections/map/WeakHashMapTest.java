package com.example.java.collections.map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new WeakHashMap<>();
        map.put(1, 1);
        map.put(127, 90);
        map.put(12132, 0);
        Integer a  = 123435;
        map.put(a, 90);
        a = null;

        Runtime.getRuntime().gc();
        Thread.sleep(1000);
        map.forEach((k, v)->{
            System.out.println("["+k+", "+ v+"]");
        });
    }
}
