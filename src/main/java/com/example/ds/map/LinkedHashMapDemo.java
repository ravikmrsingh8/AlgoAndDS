package com.example.ds.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String>   map = new LinkedHashMap<>(16, 0.8f, true);
        map.put(1, "one");
        map.put(2, "one");
        map.put(3, "one");
        map.put(4, "one");
        map.put(5, "one");
        map.put(1, "one");
        map.put(4, "one");
        map.put(5, "one");
        map.get(1);
        System.out.println(map);



        LRUCache<Integer, String> cache = new LRUCache<>(4);
        cache.put(1, "one");
        cache.put(1, "one");
        cache.put(2, "one");
        cache.put(3, "one");
        cache.put(4, "one");
        cache.put(5, "one");
        cache.put(1, "one");
        cache.put(4, "one");
        cache.put(5, "one");

        System.out.println(cache);


    }
}
