package com.example.misc.competitive.esko;

import java.util.*;

public class Units {
    Map<String, Unit> unitsMap = new HashMap<>();
    String[] units;

    Units(String[] units) {
        this.units = units;
        for (String unit : units) {
            unitsMap.put(unit, new Unit(unit));
        }
    }

    void addEquation(String unit1, String unit2, int units) {
        Unit u1 = unitsMap.get(unit1);
        Unit u2 = unitsMap.get(unit2);
        u1.conversion.put(unit2, new Rational(units,1));
        u2.conversion.put(unit1, new Rational(1,units));
    }


    void bfs() {
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.offer(units[0]);
        visited.add(units[0]);
        Unit u0 = unitsMap.get(units[0]);
        u0.key = new Rational(1,1);

        while(!q.isEmpty()) {
            Unit unit = unitsMap.get(q.poll());
            unit.conversion.forEach((v, w)-> {
                if(!visited.contains(v)) {
                    visited.add(v);
                    unitsMap.get(v).key = Rational.multiply(unit.key, w);
                    q.offer(v);
                }
            });
        }
    }
}
