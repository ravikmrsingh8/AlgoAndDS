package com.example.pattern;

public class PatternPrinter {
    boolean inc ;
    int K;

    PatternPrinter(){
        inc = false;
    }
    void print(int N, int K){
        inc = false;
        print(N,N,K);
        System.out.println();
    }
    void print(int N,int M, int K) {
        System.out.print(N + " ");
        if (N <= 0) inc = true;
        if(N == M && inc)return;
        if(inc)print(N+K, M, K);
        else print(N-K,M,K);
    }

    public static void main(String[] args) {
        PatternPrinter printer = new PatternPrinter();
        printer.print(16,5);
        printer.print(10,5);
    }
}
