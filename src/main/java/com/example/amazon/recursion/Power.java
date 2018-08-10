package com.example.amazon.recursion;

public class Power {
    public static void main(String[] args) {
        int X = 2;
        int N = 30;
        Power power = new Power();
        int value = power.findPower(X,N);
        System.out.println(value);
        System.out.println("Rec Calls:" + power.recCalls);
    }

    int recCalls =0;
    int findPower(int X, int N){
        recCalls++;
        if(X == 0 && N == 0) {
            throw new RuntimeException("0^0 is Indeterminate");
        }
        if(N == 0) return 1;
        if(N == 1) return X;
        if(X == 0) return 0;

        if(N%2 == 0) return findPower(X*X, N/2);
        else return X*findPower(X*X, (N-1)/2);

    }
}
