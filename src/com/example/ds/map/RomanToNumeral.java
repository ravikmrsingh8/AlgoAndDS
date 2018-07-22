package com.example.ds.map;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumeral {
    Map<String, Integer> map = new HashMap<>();

    RomanToNumeral() {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    int convert(String roman) {
        if (roman.isEmpty()) {
            return 0;
        } else if (roman.length() == 1) {
            return map.get(roman);
        } else if (map.containsKey(roman.substring(0, 2))) {
            return map.get(roman.substring(0, 2)) + convert(roman.substring(2));
        } else {
            return map.get(roman.substring(0, 1)) + convert(roman.substring(1));
        }
    }

    public static void main(String[] args) {
        RomanToNumeral convertor = new RomanToNumeral();
        System.out.println(convertor.convert("MCMIV"));
        System.out.println(convertor.convert("DCCLXXXVI"));
        System.out.println(convertor.convert("CDXX"));
        System.out.println(convertor.convert("MCCXXXIV"));
        System.out.println(convertor.convert("MMMCMXCIX"));

    }


}
