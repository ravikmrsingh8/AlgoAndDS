package com.example.bit;

/**
 *
 */
public class SwapEvenOddBits {
    public static void main(String[] args) {
        int N = swapBits(23);
        System.out.println(N);
    }

    static int swapBits(int N) {
        int even = N & 0xAAAAAAAA;
        int odd = N & 0x55555555;
        even = even >> 1;
        odd = odd << 1;
        return even | odd;
    }
}
