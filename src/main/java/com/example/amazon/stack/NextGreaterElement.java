package com.example.amazon.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] >= arr[i]) stack.push(i);
            else if (arr[stack.peek()] < arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    res[stack.peek()] = arr[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,2,7,2,3,6,9})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{5,6,7,8})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{8,7,6,5})));
    }
}
