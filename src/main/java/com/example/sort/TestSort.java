package com.example.sort;

public class TestSort {
    public static void main(String[] args) {
        Sorter sorter = new QuickSort();
        Utility.testSort(sorter,false,10000000,100);
    }
}
