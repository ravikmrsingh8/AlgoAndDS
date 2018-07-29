package com.example.problems.ps;

import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

public class PythagoreanTriplet {
    public static void main(String[] args) throws  Exception{

        System.out.println("All Pythagorean Triplets");
        pythagorianTriplet(new int[]{3, 1, 4, 6, 5});

        System.out.println("All Pythagorean Triplets");
        pythagorianTriplet(new int[]{10, 4, 6, 12, 5});

    }

    static void pythagorianTriplet(int[] arr) throws InterruptedException {

        int N = arr.length;
        Arrays.sort(arr);
        long[] sqrArr = new long[N];
        for(int i=0;i<N;i++)sqrArr[i]= ((long)arr[i]) * arr[i];

        for(int i = sqrArr.length-1; i>=2; i--){
            long c = sqrArr[i];
            int r = i;
            int l = 0;
            while(l<r) {
                if (c == sqrArr[l] + sqrArr[r]){
                    System.out.println("[" +arr[l] + ", " + arr[r]+", "+ arr[i]+"]");
                    l++;r--;
                } else if(c > sqrArr[l] + sqrArr[r]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
}
