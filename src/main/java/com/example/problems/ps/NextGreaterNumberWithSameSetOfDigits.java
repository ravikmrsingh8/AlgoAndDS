package com.example.problems.ps;

import java.util.Arrays;

public class NextGreaterNumberWithSameSetOfDigits {
    public static void main(String[] args) {
        System.out.println(findNextGreaterNumber("218765"));
        System.out.println(findNextGreaterNumber("18765"));
        System.out.println(findNextGreaterNumber("8765"));
        System.out.println(findNextGreaterNumber("1234"));
        System.out.println(findNextGreaterNumber("5349763"));
    }

    static String findNextGreaterNumber(String number) {
        char[] num = number.toCharArray();

        int i=num.length-2;
        while(i>=0 && num[i]>num[i+1]) i--;
        if(i == -1) return number;


        int j = findNextGreaterDigitIndex(num,i);
        swap(num, i, j);
        Arrays.sort(num, i+1, num.length);
        return new String(num);
    }

    static void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    static int findNextGreaterDigitIndex(char[] arr, int i) {
        int index = i+1;
        for(int j = i+2; j<arr.length; j++) if(arr[j] > arr[i] && arr[j] < arr[index] )index = j;
        return index;
    }
}
