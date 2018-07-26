package com.example.misc.competitive.esko;

public class Rational {
    long num;
    long den;
    Rational(long num, long den){
        this.num = num;
        this.den = den;
    }
    static Rational multiply(Rational a, Rational b) {
        Rational res = new Rational(1,1);
        res.num = b.num * a.num;
        res.den = b.den * a.den;
        return res;
    }

    static int compare(Rational a, Rational b) {
        long first = b.den * a.num;
        long sec = a.den * b.num;
        if(first < sec) return -1;
        else if(first == sec ) return 0;
        else return 1;
    }
     Long value() {
        if(num%den == 0) {
            return num/den;
        }
        else return null;
     }
}
