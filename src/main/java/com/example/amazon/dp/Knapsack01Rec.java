package com.example.amazon.dp;

/**
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 *
 * Optimal substructure
 *  there can be two cases for every item:
 *  (1) the item is included in the optimal subset,
 *  (2) not included in the optimal set.
 *
 * Algorithm:-
 * if (Number of items are 0 or W <= 0) return 0
 * If  (weight of nth item is greater than W)
 *     then the nth item cannot be included
 * else the maximum value that can be obtained from n items is max of following two values.
 *     1) Maximum value obtained by n-1 items and W weight (excluding nth item).
 *     2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth item (including nth item).
 *
 *
 */
public class Knapsack01Rec {
    public static void main(String[] args) {

        int value = knapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50);
        System.out.println("Max Value :" + value);
        System.out.println("Recursive Calls :" + count);

        value = knapsack(new int[]{5, 4, 6, 3}, new int[]{10, 40, 30, 50}, 10);
        System.out.println("Max Value :" +value);
        System.out.println("Recursive Calls :" + count);
    }

    static int count =0;
    static int knapsack(int[] wt, int[] val, int W) {
        count =0;
        return knapsack(wt, val, W, wt.length);
    }

    private static int knapsack(int[] wt, int[] val, int W, int N) {

        if(N == 0 || W <= 0) return 0;
        count++;
        if(wt[N-1] > W) {
            return knapsack(wt, val, W, N-1);
        } else {
            int value1 = knapsack(wt, val, W, N-1);
            int value2 = knapsack(wt, val, W-wt[N-1], N-1) + val[N-1];
            return Math.max(value1, value2);
        }
    }
}
