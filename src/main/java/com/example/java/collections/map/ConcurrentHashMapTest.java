package com.example.java.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1,null);
        map.put(2,"Two");
        map.put(3,"Three");
        System.out.println(map);
    }
}
