package com.example.amazon.dp;

/**
 * The length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * We find following optimal sub structure
 * let LIS(i) = length of LIS including element at ith index
 * then LIS(i) = 1 + max(LIS(j)) where j<=0<i and arr[j]< arr[i];
 * if No LIS(j) found  LSI(i) = 1
 * once done find the max among all the LIS[I];
 */
public class LIS {
    final static int NEG_INF = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(findLISLength(arr));
    }

    static int findLISLength(int[] arr) {
        int N = arr.length;
        int[] LIS = new int[N];
        LIS[0] = 1;
        for (int i = 1; i < N; i++) {
            //find max(LIS(j)) where j<=0<i and arr[j]< arr[i];
            int lis_j = NEG_INF;
            for(int j= i-1;j>=0;j--){
                if(arr[j] < arr[i] && lis_j < LIS[j]){
                    lis_j = LIS[j];
                }
            }

            LIS[i] = lis_j != NEG_INF ? 1 + lis_j : 1;
        }

        //find Maximum LIS[i]
        int lis_i = LIS[0];
        for (int i = 1; i < N; i++) {
            if (lis_i < LIS[i]) {
                lis_i = LIS[i];
            }
        }
        return lis_i;
    }
}
