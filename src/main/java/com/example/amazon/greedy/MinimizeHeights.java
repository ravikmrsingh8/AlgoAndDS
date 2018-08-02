package com.example.amazon.greedy;

/**
 * Given heights of n towers and a value k.
 * We need to either increase or decrease height of every tower by k (only once) where k > 0.
 * The task is to minimize the difference between the heights of the longest and the shortest tower after modifications,
 * and output this difference.
 *
 * Input : arr[] = {1, 10, 14, 14, 14, 15} and k = 6 
 * Output: Maximum difference is 5 arr[] = {7, 4, 8, 8, 8, 9}
 */
public class MinimizeHeights {
    public static void main(String[] args) {
        int heights[] = {1, 10, 14, 14, 14, 15};
        int k =6;
        minimizeHeights(heights, k);
    }

    private static int[] minimizeHeights(int[] heights, int k) {
        return null;
    }
}
