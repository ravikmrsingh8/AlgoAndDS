package com.example.problems.ps;

import java.util.Stack;

public class BinaryConversion {
    public static void main(String[] args) {
        System.out.println(toBinary(15));
        System.out.println(toBinary(32));
        System.out.println(toBinary(10));

    }

//    static String toBinary(int n) {
//        Stack<Integer> stack = new Stack<>();
//        while(n>0){
//            stack.push(n%2);
//            n= n/2;
//        }
//        StringBuilder sb = new StringBuilder();
//        while(!stack.isEmpty())sb.append(stack.pop());
//        return sb.toString();
//    }
//

    static String toBinary(int n) {
        if(n == 0) return "0";
        if(n == 1) return "1";
        else return toBinary(n/2) + n%2;
    }
}
