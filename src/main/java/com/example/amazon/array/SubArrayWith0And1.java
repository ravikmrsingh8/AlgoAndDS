package com.example.amazon.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing only 0s and 1s, find the largest sub array length which contains equal no of 0s and 1s.
 * Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
 * Output: 6
 * 1 to 6 (Starting and Ending indexes of output subarray)
 * Expected time complexity is O(n).
 *
 * Hint : - replace 0 by -1. Now this problem will reduce to finding  sub array  of sum 0
 */
public class SubArrayWith0And1 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(findSubArrayLength(arr));
    }

    static int findSubArrayLength(int[] arr){
        int len = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum += arr[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)) {
                len = Math.max(len, i-map.get(sum));
            } else {
                map.put(sum , i);
            }
        }
        return len;
    }
}
