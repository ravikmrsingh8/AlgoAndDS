package com.example.ds.stack.problems;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 1, 2, 3, 25, 10};
        nextGreaterElement(arr);
    }

    static void nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        if (arr.length == 0) return;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                System.out.println(stack.pop()+" -> "+arr[i]);
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" -> -1");
        }
    }
}
