package com.example.misc.competitive.esko;

import java.util.*;

public class UnitBalancer {
    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);

        String[] units = in.nextLine().split(",");
        for(int i=0;i<units.length;i++){
            units[i] = units[i].trim();
        }

        Units _units = new Units(units);
        for(int i=0;i<units.length-1;i++) {
            String unit1 = in.next().trim();
            in.next();
            int num = in.nextInt();
            String unit2 = in.next().trim();
            _units.addEquation(unit1, unit2, num);
        }

        _units.bfs();
        Map<String, Unit> unitMap = _units.unitsMap;
        Arrays.sort(units, (s1, s2)-> {
           Unit u1 = unitMap.get(s1);
           Unit u2 = unitMap.get(s2);
           return Rational.compare(u1.key, u2.key);
        });

        //conversion Factor
        Rational _u0f = unitMap.get(units[0]).key;
        Rational cf = new Rational(_u0f.den, _u0f.num);

        //Prepare Output
        StringBuilder sb = new StringBuilder();
        Unit u0 = unitMap.get(units[0]);
        Long v0 = Rational.multiply(u0.key, cf).value();
        if(v0 != null) {
            sb.append(v0).append(u0.unit);
        }

        for(int i=1;i<units.length;i++){
            Unit u = unitMap.get(units[i]);
            Long val = Rational.multiply(u.key,cf).value();
            if(val != null) {
                sb.append(" = ");
                sb.append(val).append(u.unit);
            }
        }

        System.out.println(sb);
    }

}