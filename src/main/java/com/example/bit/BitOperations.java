package com.example.bit;

/**
 * N- 1 has all the bits flipped till the first set bits
 * like for 5 bits are 101 and in 4 bits are like 100
 * For 14 , bits are 1110  for 13 it will be 1100
 *
 */
public class BitOperations {
    public static void main(String[] args) {
        System.out.println("FirstSetBit(13):"+firstSetBit(13));
        System.out.println("FirstSetBit(14):"+firstSetBit(14));
        System.out.println("ClearFirstSetBit(14):"+clearFirstSetBit(14));
        System.out.println("numberOfSetBits(21):"+numberOfSetBits(21));
        System.out.println("bitCount(21):"+bitCount(21));
        System.out.println("setBitAt(20,4):"+setBitAt(20,4));
        System.out.println("clearBitAt(20,3):"+setBitAt(20,3));
        System.out.println("clearBitAt(20,4):"+clearBitAt(20,4));
    }

    static int firstSetBit(int N){
        return N & ~(N-1);
    }

    static int clearFirstSetBit(int N){
        return N & (N-1);
    }

    static int numberOfSetBits(int N){
        int count =0;
        while(N != 0){
            N = N & (N-1);
            count++;
        }
        return count;
    }
    static int bitCount(int N){
        return Integer.bitCount(N);
    }

    static int setBitAt(int N, int index){
        int mask = 1 << index;
        return N |= mask;
    }
    static int clearBitAt(int N, int index){
        int mask = ~(1 << index);
        return N &= mask;
    }
}
