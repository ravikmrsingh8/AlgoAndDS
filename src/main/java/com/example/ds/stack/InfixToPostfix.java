package com.example.ds.stack;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InfixToPostfix {
    static Set<String> operators = new HashSet<>(Arrays.asList(
            "+","-","*","/","^"
    ));

    static Set<String> parenthesis = new HashSet<>(Arrays.asList(
            "(", ")"
    ));

    public static void main(String[] args) {
        String expr =" a + b * ( c ^ d - e ) ^ ( f + g * h ) - i";
        String postfix = infixToPostfix(expr.split("\\s+"));
        System.out.println(postfix);
    }

    public static String infixToPostfix(String[] infix){

        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(String token : infix){
            if(operators.contains(token)){
                postfix.append(operators(token, stack));
            } else if(parenthesis.contains(token)){
                postfix.append(parenthesis(token,stack));
            }else {
                postfix.append(token);
            }
        }
        while(!stack.isEmpty())postfix.append(stack.pop());
        return postfix.toString();
    }

    static String parenthesis(String token, Stack<String> stack){
        StringBuilder sb = new StringBuilder();
        if("(".equals(token)){
            stack.push(token);
        } else {
            while(!stack.isEmpty() && !"(".equals(stack.peek())){
                sb.append(stack.pop());
            }
            if(!stack.isEmpty())stack.pop();
        }
        return sb.toString();
    }

    static String operators(String operator, Stack<String> stack){
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            String top = stack.peek();
            if(operators.contains(top) && higherPrecedence(top,operator)){
                sb.append(stack.pop());
            } else {
                break;
            }
        }
        stack.push(operator);
        return sb.toString();
    }

    static boolean higherPrecedence(String operator1, String operator2){
        String operators ="^/*+-";
        return operators.indexOf(operator1)<operators.indexOf(operator2);
    }

}
