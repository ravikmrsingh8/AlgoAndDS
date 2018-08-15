package com.example.bit;


public class RotateBits {
    public static void main(String[] args) {
        int number = 24;
        int times = 34;
        System.out.println(rotateLeft(number, times));
        System.out.println(rotateRight(number, times));
    }

    static int rotateLeft(int N, int K){
        K = K% Integer.SIZE;
        return N<<K | N >> (Integer.SIZE - K);

    }
    static int rotateRight(int N, int K){
        K = K%Integer.SIZE;
        return N>>K | N<< (Integer.SIZE-K);
    }
}
