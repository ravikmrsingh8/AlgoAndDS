package gfg.mustdoques.array;

import gfg.mustdoques.InputReader;

/**
 * Given an gfg.mustdoques.array containing both negative and positive integers. \
 * Find the contiguous sub-gfg.mustdoques.array with maximum sum.
 */
public class Kadane {
    public static void main(String[] args) {
        System.out.println(kadane(new int[]{4, -1, -2, 20, -20}));
        System.out.println(kadane(new int[]{-1,-2,-3,-4}));
        System.out.println(kadane2(new int[]{4, -1, -2, 20, -20}));
        System.out.println(kadane2(new int[]{-1,-2,-3,-4}));

        //Test Kadane
        InputReader in= new InputReader(System.in);
        while(true) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++)arr[i] =  in.nextInt();
            System.out.println(kadane2(arr));
        }
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


    static int kadane2(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];
        for(int i=1;i<arr.length;i++){
            sum = Math.max(arr[i], arr[i]+sum);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
