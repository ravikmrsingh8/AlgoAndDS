package com.example.misc.competitive.esko;

import java.util.HashMap;
import java.util.Map;

public class Unit {
    String unit;
    Map<String, Rational> conversion = new HashMap<>();
    Rational key = new Rational(1,1);
    Unit(String unit) {
        this.unit =unit;
    }
}
