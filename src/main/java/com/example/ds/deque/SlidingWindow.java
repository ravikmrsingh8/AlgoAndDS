package com.example.ds.deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {
    public static void main(String[] args) {
        List<Integer> maxElements = slidingWindow(new int[]{5,6,1,7,2,3,4,5,1,3,1,2,3,7,6,5}, 4);
        //slidingWindow(new int[]{3, 2, 1, 1, 1, 5, 2, 3, 6}, 3);
        System.out.println(maxElements);
    }

    static List<Integer> slidingWindow(int[] arr, int window) {
        List<Integer> maxElements = new ArrayList<>();

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < window; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) q.pollLast();
            q.offerLast(i);
        }
        if(!q.isEmpty())maxElements.add(arr[q.peekFirst()]);

        for (int i = window; i < arr.length; i++) {
            if(!q.isEmpty() && q.peekFirst()<= i-window) q.pollFirst();
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i]) q.pollLast();
            q.offerLast(i);
            maxElements.add(arr[q.peekFirst()]);
        }

        return maxElements;
    }

}
