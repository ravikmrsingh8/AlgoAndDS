package com.example.sort;

import java.util.Random;

public class Utility {
    public static void testSort(Sorter sorter, boolean verbose, int arraySize, int nTest) {
        long T = 0;
        int N = nTest;
        for(int test= 1; test<=nTest; test++) {
            int[] arr = getArray(arraySize);

            if(verbose){
                System.out.print("Array:");printArray(arr);
            }

            long t1 = System.nanoTime()/1000;
            sorter.sort(arr);
            long t2 = System.nanoTime()/1000;
            System.out.println("Test:"+test);
            T += (t2-t1);
            boolean result = testSort(arr);
            if(!result){
                System.out.println("Test "+test+" Failed for Array");
                printArray(arr);
                break;
            } else {
                System.out.println("PASS\tTime:"+(t2-t1)/1000.0 +" ms");
            }
            if(verbose){
                System.out.print("Sorted Array:");printArray(arr);
            }
        }
        System.out.println("Average Time "+ (T/N)+"ms");

    }
    public static boolean testSort(int[] numbers){
        for(int i=0;i<numbers.length-1;i++) {
            if(numbers[i]>numbers[i+1]){
                System.out.println(numbers[i] + "," + numbers[i+1]);
                return false;
            }
        }
        return true;
    }

    public static int[] getArray(int N) {
        int[] numbers = new int[N];
        Random random = new Random();
        for(int i=0 ;i<N; i++) {
            numbers[i] = random.nextInt(1000);
        }
        return numbers;
    }

    public static void printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i:arr){
            sb.append(i).append(",");
        }
        sb.replace(sb.length()-1,sb.length()," ");
        sb.append("]");
        System.out.println(sb);;
    }

    public static void swap(int[] arr,int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
