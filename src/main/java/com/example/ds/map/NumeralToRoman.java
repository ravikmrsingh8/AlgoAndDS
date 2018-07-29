package com.example.ds.map;

import java.util.Map;
import java.util.TreeMap;

public class NumeralToRoman {
    TreeMap<Integer, String> map = new TreeMap<>();

    NumeralToRoman() {
        map.put(1, "I");
        map.put(4,"IV");
        map.put(5, "V" );
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
    }

    String convert(int numeral) {
        if(numeral == 0) return "";
        Map.Entry<Integer, String> entry = map.floorEntry(numeral);
        return entry.getValue() + convert(numeral - entry.getKey());
    }

    public static void main(String[] args) {
        NumeralToRoman convertor = new NumeralToRoman();
        System.out.println(convertor.convert(786));
        System.out.println(convertor.convert(3999));
        System.out.println(convertor.convert(420));
        System.out.println(convertor.convert(575));
        System.out.println(convertor.convert(75));

    }
}
