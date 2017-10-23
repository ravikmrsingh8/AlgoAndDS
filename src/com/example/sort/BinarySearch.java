package com.example.sort;

public class BinarySearch {
    public static int search(int[] arr, int data) {
        return search(arr, data, 0, arr.length - 1);
    }

    private static int search(int[] arr, int data, int l, int h) {
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == data) {
                return m;
            } else if (arr[m] > data) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 12, 14, 35, 78, 112};
        System.out.println(search(nums, 6));
        System.out.println(search(nums, 14));
        System.out.println(search(nums, 15));
        System.out.println(search(nums, 112));
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 1));
        System.out.println(search(nums, -1));
        System.out.println(search(nums, 908080098));
    }

}
