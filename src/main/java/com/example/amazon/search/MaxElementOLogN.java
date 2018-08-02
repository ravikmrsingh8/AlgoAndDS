package com.example.amazon.search;
/**
 *
 * Given an array , elements are stored in increasing order initially and then after reaching to a peak element ,
 * they are in decreasing order. Find the highest element.
 *
 * eg. [1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
 *  OUTPUT: 6
 */
public class MaxElementOLogN {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        int index = findMaxElementIndex(arr, 0, arr.length-1);
        System.out.println("Max Element :"+arr[index]);

        arr = new int[]{1, 2, 3, 4, 5, 6};
        index = findMaxElementIndex(arr, 0, arr.length-1);
        System.out.println("Max Element :"+arr[index]);


        arr = new int[]{6, 5, 4, 3, 2, 1};
        index = findMaxElementIndex(arr, 0, arr.length-1);
        System.out.println("Max Element :"+arr[index]);
    }
    static int findMaxElementIndex(int[] arr, int low, int high){
        if(low == high) return low;
        if(high-low == 1) return arr[low]>arr[high]? low:high;

        int mid = low+ (high-low)/2;
        if(arr[mid]>arr[mid-1] && arr[mid]> arr[mid+1])return mid;
        else if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]){
            return findMaxElementIndex(arr, low, mid-1);
        } else {
            return findMaxElementIndex(arr, mid+1, high);
        }
    }
}
