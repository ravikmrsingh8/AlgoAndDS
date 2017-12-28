package com.example.ds.stack.problems;

import java.util.Stack;

public class ReverseStackRec {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack" + stack);

        reverse(stack);
        System.out.println("Stack" + stack);
    }

    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int val = stack.pop();
        reverse(stack);
        insert(stack, val);

    }

    static void insert(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int val = stack.pop();
        insert(stack, data);
        stack.push(val);
    }
}
