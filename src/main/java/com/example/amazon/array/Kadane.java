package com.example.amazon.array;

public class Kadane {
    public static void main(String[] args) {

        System.out.println(kadane(new int[]{4, -1, -2, 20, -20}));
        System.out.println(kadane(new int[]{-1,-2,-3,-4}));

    }

    static int kadane(int[] arr){
        int sum =0;
        int max= 0;
        boolean allNeg = true;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum < 0) {
                sum =0;
            } else if(sum > max) {
                max = sum;
                allNeg = false;
            }
        }

        if(!allNeg) return max;

        max = arr[0];
        for(int i=1;i<arr.length;i++)max = Math.max(max, arr[i]);
        return max;
    }
}
