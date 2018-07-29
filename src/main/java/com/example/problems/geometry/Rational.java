package com.example.problems.geometry;

public class Rational {
    public int p;
    public int q;

    public Rational(int p, int q){
        if(p == 0 && q == 0) {
            throw new IllegalArgumentException("0/0 Not defined");
        }
        if(p != 0 && q != 0) {
            int g = GCD(p,q);
            p /= g;
            q /= g;
        }
        this.p = p;
        this.q = q;
    }

    private int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }

    @Override
    public int hashCode() {
        if(p == 0 ) return 0;
        else if(q == 0 ) return Integer.MAX_VALUE;
        else return p^q;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Rational)) return false;
        Rational r = (Rational)obj;
        if(r.p == 0 && p == 0) return true;
        if(r.q == 0 && q == 0) return true;
        int g = GCD(r.p, r.q);
        return  (p == r.p / g) && (q == r.q /g);

    }

    @Override
    public String toString() {
        if(p == 0) return String.valueOf(0);
        if(q == 0) return String.valueOf(Integer.MAX_VALUE);
        return new StringBuilder().append(p).append("/").append(q).toString();
    }
}
