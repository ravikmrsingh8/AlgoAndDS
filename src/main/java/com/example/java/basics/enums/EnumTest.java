package com.example.java.basics.enums;

import java.util.EnumMap;
import java.util.Map;

public class EnumTest {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        switch(day) {
            case MONDAY:
                System.out.println("Monday");
                break;
            case FRIDAY:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Don't Know");
        }

        Map<Day, String> enumMap = new EnumMap<Day, String>(Day.class);
        enumMap.put(Day.MONDAY, "MONDAY");
        System.out.println(enumMap.get(Day.MONDAY));

    }
}
