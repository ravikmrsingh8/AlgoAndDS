package com.example.ds.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostfixEvaluation {
    private static Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    private static boolean isOperator(String operator) {
        return operators.contains(operator.trim());
    }

    public static void main(String[] args) {
        String expression = "10  4 3 * +  9 - ";
        System.out.println(evaluate(expression));
    }

    private static int calculate(int b, int a, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        throw new IllegalArgumentException("Not valid operator");
    }

    private static int evaluate(String expression) {
        String[] tokens = expression.split("\\s+");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            token = token.trim();
            if (isOperator(token)) {
                int result = calculate(stack.pop(), stack.pop(), token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
