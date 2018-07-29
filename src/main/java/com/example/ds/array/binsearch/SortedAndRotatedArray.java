package com.example.ds.array.binsearch;
//Not yet Complete
public class SortedAndRotatedArray {
    public static void main(String[] args) {
        int index1 = findElement(new int[]{5,9,10,1,3,4}, 9);
        int index2 = findElement(new int[]{5,9,10,11,13,14}, 9);
        System.out.println("Found at "+index1);
        System.out.println("Found at "+index2);
    }


    private static int findElement(int[] arr, int key){
        int index = findPivot(arr);
        if(arr[index] == key) return index;

        if (key >= arr[0]){
            return binarySearch(arr, key, 0, index);
        } else {
            return binarySearch(arr, key, index + 1 ,arr.length-1);
        }
    }

    private static int findPivot(int[] arr){
        int pivotIndex = findPivot(arr, 0, arr.length-1);
        System.out.println("PivotIndex " + pivotIndex);
        return pivotIndex;
    }



    private static int findPivot(int[] arr, int l, int h){
        if(l < h){
            int mid = l + (h-l)/2;
            if(arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid] > arr[0]) return findPivot(arr, mid+1, h);
            else return findPivot(arr, l, mid-1);
        } else if(l==h){
            return h;
        }

        return -1;
    }

    private static int binarySearch(int[] arr, int key, int low, int high){
        if(low <= high) {
            int mid = low + (high -low)/2;
            if(arr[mid] == key) {
                return mid;
            } else if(key > arr[mid] ) {
                return binarySearch(arr, key, mid +1, high);
            } else {
                return binarySearch(arr, key, 0, mid -1);
            }
        }
        return -1;
    }

}
