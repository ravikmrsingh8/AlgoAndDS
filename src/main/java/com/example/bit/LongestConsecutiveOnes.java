package com.example.bit;

public class LongestConsecutiveOnes {
    public static void main(String[] args) {
        int N = 26;
        System.out.println(Integer.toBinaryString(N));
        System.out.println(longestConsOne(N));
    }

    static int longestConsOne(int N){

        int count=0;
        while((N) != 0){
            N = N<<1 & N;
            count++;
        }
        return count;
    }
}
