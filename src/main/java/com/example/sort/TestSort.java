package com.example.sort;

public class TestSort {
    public static void main(String[] args) {
        Sorter sorter = new MergeSort();
        Utility.testSort(sorter,false,1000000,100);
    }
}
