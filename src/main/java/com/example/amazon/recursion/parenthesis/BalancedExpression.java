package com.example.amazon.recursion.parenthesis;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class BalancedExpression {
    public static void main(String[] args) {
        evaluate(BalancedExpression::getExpression, 2);
        evaluate(BalancedExpression::getExpression, 10);
        evaluate(BalancedExpression::getExpression, 13);

        System.out.println("Combination of Parenthesis for 3:\n"+getExpression(3));


    }

    static Set<String> getExpression(int N){
        Set<String> exprs = new HashSet<>();
        exprs.add("()");
        if(N == 1) return exprs;
        for(int i=1;i<N;i++)exprs = addParenthesis(exprs);
        return exprs;

    }
    static Set<String> addParenthesis(Set<String> prevSet){
        Set<String> list = new HashSet<>();

        prevSet.forEach(expr ->{
            for(int i=0;i<=expr.length();i++){
                list.add(expr.substring(0,i)+ "()"+ expr.substring(i));
            }
        });
        return list;
    }
    static void evaluate(Function<Integer, Set<String>> func, int N){
        long start = System.nanoTime();
        Set<String> set = func.apply(N);
        long end = System.nanoTime();
        System.out.println("Time Taken for "+N+" parenthesis: "+ (end-start)/Math.pow(10,6)+" ms");
    }


}
