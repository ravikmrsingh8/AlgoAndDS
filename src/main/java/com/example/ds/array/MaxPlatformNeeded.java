package com.example.ds.array;

import java.util.Arrays;

public class MaxPlatformNeeded {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int N = findPlatform(arr,dep);
        System.out.println("Platform needed " + N);
    }

    static int findPlatform(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat = 0;
        int i = 0;
        int j = 0;
        int result = plat;
        while(i < arr.length && j < arr.length){
            if(arr[i] <= dep[j]){
                i++;
                plat++;
                if(plat > result) result = plat;
            } else {
                j++;
                plat--;
            }
        }
        return result;
    }
}
